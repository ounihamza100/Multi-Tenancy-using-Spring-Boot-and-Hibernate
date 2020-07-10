package io.houni.multitenancyspringboothibernate.context;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hamza Ouni
 */

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String tenantID = request.getHeader("X-TenantID");
        System.out.println("RequestURI::" + requestURI +" || Search for X-TenantID  :: " + tenantID);
        if (tenantID == null) {
            response.getWriter().write("X-TenantID not present in the Request Header");
            response.setStatus(400);
            return false;
        }

        TenantContext.setCurrentTenant(tenantID);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
