package com.yn.interceptors;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.yn.annotation.DefaultVal;

public class DefaultValue implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(DefaultVal.class);
	}

	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		DefaultVal defaultVal = parameter.getParameterAnnotation(DefaultVal.class);
		if(defaultVal != null) {
			return defaultVal.value();
		}
		
		return null;
	}

}
