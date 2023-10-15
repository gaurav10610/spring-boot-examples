package com.example.springboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.springboot.domain.context.ApiRequestContext;
import com.example.springboot.domain.context.EmployeeConfig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestContextInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle of request context interceptor....");

		/**
		 * prepare API request context from request
		 */
		String country = request.getHeader("X-COUNTRY-ID");
		ApiRequestContext.setContext(EmployeeConfig.builder().country(country).build());

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion of request context interceptor....");

		/**
		 * clear the request context
		 */
		ApiRequestContext.clear();
	}

}
