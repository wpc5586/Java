package com.aaron.aaronworld.controller;

import com.aaron.aaronworld.service.LoginService;
import com.aaron.aaronworld.service.MainService;
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
public class MainController {

    /** MainService */
    @Resource(name = "MainServiceImpl")
    private MainService mainService;

    @RequestMapping("/getMainContent.do")
    @ResponseBody
    public Map<String, Object> getMainContent(HttpServletRequest request, HttpServletResponse response, String userId, String password) {
        Map<String,Object> map = new HashMap<>();
//        map = loginService.login(AES.decrypt(userId), AES.decrypt(password), "", "", "", "", "", "", "");
        return map;
    }

    @RequestMapping("/getVersion.do")
    @ResponseBody
    public Map<String, Object> getVersion(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map;
        map = mainService.getVersion();
        return map;
    }
}
