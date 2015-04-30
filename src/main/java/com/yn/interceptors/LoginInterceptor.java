package com.yn.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private ThreadLocal<Long> local = new ThreadLocal<Long>();
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		local.set(System.currentTimeMillis());
		System.out.println(this);
		return super.preHandle(request, response, handler);
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long end = System.currentTimeMillis() - local.get();
		local.remove();
		System.out.println("请求时间为:" + end);
		if(ex != null) {
			System.out.println("异常：" + ex.getMessage());
		}
		
//		super.afterCompletion(request, response, handler, ex);
	}

	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
