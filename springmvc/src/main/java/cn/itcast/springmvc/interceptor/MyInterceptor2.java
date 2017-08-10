package cn.itcast.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {

	/**
	 * 前置方法，在Handler方法执行之前执行，顺序执行
	 * 返回值，返回true拦截器放行 false拦截器不通过，后续业务逻辑不再执行
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor2：前置方法正在执行！");
		return false;
	}

	/**
	 * 后置方法，在执行完Handler方法之后执行，倒序执行
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor2：后置方法正在执行！");
		
	}

	/**
	 * 完成方法，在视图渲染完成之后执行，倒序执行
	 */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor2：完成方法正在执行！");
		
	}

}
