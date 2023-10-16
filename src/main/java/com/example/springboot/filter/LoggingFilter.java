package com.example.springboot.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(2)
public class LoggingFilter extends OncePerRequestFilter {

	private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
		try {
			return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		long startTime = System.currentTimeMillis();
		filterChain.doFilter(requestWrapper, responseWrapper);
		long timeTaken = System.currentTimeMillis() - startTime;

		String requestBody = getStringValue(requestWrapper.getContentAsByteArray(), request.getCharacterEncoding());
		String responseBody = getStringValue(responseWrapper.getContentAsByteArray(), response.getCharacterEncoding());

		log.info(
				"[API REQUEST]: METHOD={}; REQUEST_URI={}; REQUEST_PAYLOAD={}; RESPONSE_CODE={}; RESPONSE_PAYLOAD={}; TIME_TAKEN={}ms",
				request.getMethod(), request.getRequestURI(), requestBody, response.getStatus(), responseBody,
				timeTaken);
		responseWrapper.copyBodyToResponse();

	}

}
