package com.example.demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.utils.ApiResponse;
import com.google.gson.Gson;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTBuilder jwtBuilder;

    @Autowired
    private UserService userService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("/public") || request.getServletPath().contains("/swagger-ui");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setHeader("Content-Type", "application/json");
        final String requestTokenHeader = request.getHeader("Authorization");

        if (requestTokenHeader == null || requestTokenHeader.length() == 0) {
            // Response
            ApiResponse res = new ApiResponse(false, null, "Token not found!", null);
            response.getWriter().write(gson.toJson(res));
        } else {
            if (jwtBuilder.isExpired(requestTokenHeader)) {
                ApiResponse res = new ApiResponse(false, "Token Expired!", null);
                response.getWriter().write(gson.toJson(res));
            }
            else{
                int userId = Integer.parseInt(jwtBuilder.getUserIdFromToken(requestTokenHeader));
                User user = userService.getById(userId);

                if(user == null){
                    ApiResponse res = new ApiResponse(false, "Token Corrupted!", null);
                    response.getWriter().write(gson.toJson(res));
                }
                else{
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							user, null, user.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					filterChain.doFilter(request, response);
                }
            }
        }
    }

}
