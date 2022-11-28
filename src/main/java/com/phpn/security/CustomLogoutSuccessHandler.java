//package com.phpn.security;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Arrays;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.util.Assert;
//import org.springframework.util.StringUtils;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
//
//    private final List<String> cookies;
//
//    public CustomLogoutSuccessHandler(String... cookies) {
//        Assert.notNull(cookies, "Cookies list can't be null!");
//        this.cookies = Arrays.asList(cookies);
//    }
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        for (String $ : cookies) {
//            Cookie cookie = new Cookie($, null);
//            String getCookiePath = httpServletRequest.getContextPath();
//
//            if (!StringUtils.hasLength(getCookiePath)) getCookiePath = "/";
//
//            cookie.setPath(getCookiePath);
//            cookie.setMaxAge(0);
//
//            httpServletResponse.addCookie(cookie);
//        }
//
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
//    }
//
//}