package com.yn.interceptors;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.yn.annotation.DefaultVal;
import com.yn.annotation.Param;

public class ParamInterceptor implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(Param.class);
	}

	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		Param p = parameter.getParameterAnnotation(Param.class);
		if( p!= null) {
			System.out.println(p.value() + " ============");
			String value= webRequest.getParameter(p.value());
			if(value == null) {
				DefaultVal def = parameter.getParameterAnnotation(DefaultVal.class);
				return def == null ? null : def.value();
			}
			return value;
		}
		return webRequest.getParameter(parameter.getParameterName());
	}
}
