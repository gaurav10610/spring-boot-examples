package com.example.springboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiRequestHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle of api request handler interceptor....");
		log.info("[Received request]: {} {} from {}", request.getMethod(), request.getRequestURI(),
				request.getRemoteAddr());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("[Sent response]: {} {} with status {} and exception {}", request.getMethod(), request.getRequestURI(),
				response.getStatus(), ex);
		log.info("afterCompletion of api request handler interceptor....");

	}

}
