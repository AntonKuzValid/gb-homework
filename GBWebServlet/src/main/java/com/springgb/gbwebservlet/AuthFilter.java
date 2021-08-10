package com.springgb.gbwebservlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends HttpFilter {
    private final static String SESSION_ATTRIBUTE_TOKEN = "token";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object sessionToken = req.getSession().getAttribute(SESSION_ATTRIBUTE_TOKEN);
        String token = null;
        if (sessionToken != null) {
            token = sessionToken.toString();
        }
        final String paramToken = req.getParameter("token");
        if (paramToken != null) {
            token = paramToken;
        }
        if (!isValid(token)) {
            res.sendError(401, "token is invalid");
        }
        if (sessionToken == null || sessionToken != paramToken) {
            req.getSession().setAttribute(SESSION_ATTRIBUTE_TOKEN, token);
        }
        super.doFilter(req, res, chain);

    }

    private boolean isValid(String token) {
        if ("fullAccess".equals(token)) {
            return true;
        }
        return false;
    }

}
