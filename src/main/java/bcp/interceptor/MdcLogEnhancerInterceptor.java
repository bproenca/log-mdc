package bcp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MdcLogEnhancerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!"nolog".equalsIgnoreCase(request.getQueryString())) {
            String userAgent = request.getHeader("user-agent");
            MDC.put("browser", userAgent);
        }
        return true;
    }
}
