package com.laboratoris.retea_socializare_backend.security;

import org.springframework.security.web.AuthenticationEntryPoint;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomJwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        try {
            response.setStatus(403);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter()
                    .write(new JSONObject()
                            .put("timestamp", System.currentTimeMillis())
                            .put("message", authException.getMessage())
                            .put("status", 403)
                            .toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
