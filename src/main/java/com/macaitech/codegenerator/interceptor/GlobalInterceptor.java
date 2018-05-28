package com.macaitech.codegenerator.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.macaitech.codegenerator.config.CodeGeneratorConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CodeGeneratorConfig codeGeneratorConfig;

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        boolean result = true;

        List<Annotation> marks = new ArrayList<Annotation>();
        marks.addAll(Arrays.asList(handlerMethod.getBeanType().getAnnotations()));
        marks.addAll(Arrays.asList(handlerMethod.getMethod().getAnnotations()));

        boolean isAjax = false;
        
//        isAjax = marks.stream().anyMatch(e -> e instanceof ResponseBody);
//
//        if (marks.stream().anyMatch(e -> e instanceof RequireSession)) {
//            SysUser user = (SysUser) session.getAttribute("SysUser");
//            if (user == null) {
//                result = false;
//            } else if (marks.stream().anyMatch(e -> e instanceof RequireMenu)) {
//                List<SysMenu> menuList = (List<SysMenu>) session.getAttribute("MenuList");
//                Optional<Annotation> annotation = marks.stream().filter(m -> m instanceof RequireMenu).findFirst();
//                RequireMenu menuMark = (RequireMenu) annotation.get();
//                if (menuList.stream().noneMatch(m -> m.getMenuCode().equals(menuMark.value()))) {
//                    result = false;
//                }
//            }
//        }

        if (!result) {
            if (!isAjax) {
                response.sendRedirect(StringUtils.isEmpty(codeGeneratorConfig.getWebRoot()) ? "/" : codeGeneratorConfig.getWebRoot());
            } else {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.flushBuffer();
            }
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("CodeGenerator", codeGeneratorConfig);
        }
    }
}
