package com.example.shardingspherebase.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ClientIdInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<String> clientIdThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientId = request.getHeader("client_id");
        if (clientId != null) {
            clientIdThreadLocal.set(clientId);
        }
        return true;
    }

    public static String getClientId() {
        return clientIdThreadLocal.get();
    }

    public static void clear() {
        clientIdThreadLocal.remove();
    }
}