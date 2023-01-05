package com.laboratoris.retea_socializare_backend.security;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAccesDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(403);
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter()
                    .write(new JSONObject()
                            .put("timestamp", System.currentTimeMillis())
                            .put("message", "Access denied")
                            .put("status", 403)
                            .toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
