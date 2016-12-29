package cn.footballtime.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.footballtime.web.model.CookieValueInfo;
import cn.footballtime.web.model.UserLoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.footballtime.web.config.AppSetting;
import cn.footballtime.utils.security.AESUtil;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private HttpServletRequest request; //这里可以获取到request

    @RequestMapping("/index")
    public String index() {
        return "login/index";
    }

    @RequestMapping("/logon")
    public void logOn(String returnurl, HttpServletResponse response) throws Exception {
        UUID uuid = UUID.randomUUID();
        String guid = uuid.toString().toUpperCase();
        Cookie cookie = new Cookie(AppSetting.getCookieName(), AESUtil.encrypt("lgchao^"+guid,AppSetting.getCookieAesEncryptKey()));// 创建一个cookie，cookie的名字是footballday_cookie
        cookie.setPath("/");
        //cookie.setSecure(true);
        cookie.setDomain(AppSetting.getCookieDomain());//footballtime.cn
        // 将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        response.addCookie(cookie);

        response.sendRedirect(returnurl);
    }

    @RequestMapping("/logout")
    public void logOut(HttpServletResponse response) {

        Cookie[] cookies=request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {

                String cookieName = cookies[i].getName();
                if (cookieName.equals(AppSetting.getCookieName())) {
                    cookies[i].setValue(null);
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }

        try {
            response.sendRedirect(AppSetting.getSiteDomainUrl());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getLoginShowName",method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public UserLoginStatus getLoginShowName() {
        UserLoginStatus obj = new UserLoginStatus();
        CookieValueInfo info =new CookieValueInfo();
        if (isAuthenticated(info)) {
            obj.setIsAuthenticated(1);
            obj.setShowName(info.getUserName());
        } else {
            obj.setIsAuthenticated(0);
            obj.setShowName("");
        }

        return obj;
    }

    private boolean isAuthenticated(CookieValueInfo info) {
        boolean isPass = false;

        Cookie[] cookies=request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {

                String cookieName = cookies[i].getName();
                if (cookieName.equals(AppSetting.getCookieName())) {
                    try {
                        String[] cookieValueArray = AESUtil.decrypt(cookies[i].getValue(),AppSetting.getCookieAesEncryptKey()).split("\\^");
                        info.setUserName(cookieValueArray[0]);
                        info.setCacheKey(cookieValueArray[1]);

                        isPass = true;
                    } catch (Exception e) {
                        isPass = false;
                        //e.printStackTrace();
                    }

                    break;
                }
            }
        }

        return isPass;
    }
}
