package bcp.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Component
public class MdcLogEnhancerFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (!"nolog".equalsIgnoreCase(req.getQueryString())) {
            String userAgent = req.getHeader("user-agent");
            MDC.put("browser", userAgent);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
