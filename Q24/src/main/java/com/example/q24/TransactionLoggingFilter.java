package com.example.q24;

import org.springframework.stereotype.Component;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionLoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String amount = request.getParameter("amount");
        String clientIP = request.getRemoteAddr();
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + timestamp + "] Transaction Request from IP: " +
                clientIP + " | Amount: Rs." + amount);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
