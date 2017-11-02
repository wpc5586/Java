package com.aaron.aaronworld.base.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaron.aaronworld.utils.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    /**
     * 登录拦截
     *
     * @param request
     * @param response
     * @return boolean
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        /** 拦截url */
        String requestUri = request.getRequestURI();

        // 放行url列表
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        // 判断是否为Web
        Boolean isWeb = false;
        Cookie[] cookies = request.getCookies();
        if (EmptyUtil.isNotEmpty(cookies)) {
            isWeb = false;
        }
        String token = request.getParameter("token");
        if (EmptyUtil.isEmpty(token) && EmptyUtil.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if ("token".equalsIgnoreCase(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        if (EmptyUtil.isNotEmpty(token)) {
            // token验证
            List<String> subTokenList = Auth.getSubTokens(token);
            if (Auth.isValid(subTokenList) && Auth.isLive(subTokenList)) {
//                request.setAttribute("cityCode", Auth.getCityId(subTokenList));
                request.setAttribute("userId", Auth.getUserId(subTokenList));
                return true;
            }
        }
        if (isWeb) {
            // 返回登录页面
            Cookie cookie = new Cookie("token", "");
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
//            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            // 返回失败结果
            PrintWriter out = response.getWriter();
            out.print(ResponseUtil.returnMapNoAES(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0002));
        }
        return false;

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(ex);
    }

    protected void noHandlerFound(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath() + "/notFound");
    }
}