package com.aaron.aaronworld.controller;

import com.aaron.aaronworld.service.LoginService;
import com.aaron.aaronworld.utils.AES;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/aaron")
public class LoginController {

    /** 登录Service */
    @Resource(name = "LoginServiceImpl")
    private LoginService loginService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, String userId, String password, String phone,
                                     String imsi, String imei, String channelId, String deviceType) {
        Map<String,Object> map = new HashMap<>();
        map = loginService.login(AES.decrypt(userId), AES.decrypt(password), AES.decrypt(phone), AES.decrypt(imsi), AES.decrypt(imei), AES.decrypt(channelId), AES.decrypt(deviceType));
        return map;
    }

    @RequestMapping("/regist.do")
    @ResponseBody
    public Map<String, Object> regist(HttpServletRequest request, HttpServletResponse response, String userId, String password, String phone) {
        Map<String,Object> map = new HashMap<>();
        map = loginService.regist(AES.decrypt(userId), AES.decrypt(password), AES.decrypt(phone));
        return map;
    }
}
