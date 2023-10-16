package com.example.springboot.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class RequestIdFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			MDC.put("requestId", UUID.randomUUID().toString());
			filterChain.doFilter(request, response);
		}
		catch (Exception ex) {
			log.error("Exception occurred in filter while setting UUID for logs", ex);
		}
		finally {
			MDC.remove("requestId");
		}

	}

}
