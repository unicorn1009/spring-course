package com.unicorn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *     拦截器
 * </p>
 * Created on 2021/03/30 15:17
 *
 * @author Unicorn
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * preHandle : 预处理方法
     * 特点 :
     *      1. 在控制器方法之前先执行的
     *      2. 在这个方法中可以获得请求信息, 验证请求是否符合要求, 如是否登录等
     *      3. 如果拦截器判断请求信息不符合要求, 可以截断请求, 请求就不会被处理器方法处理
     *      3. 如果判断符合要求, 则可以放行请求, 此时控制器方法才会被执行
     * @param request 请求
     * @param response  应答
     * @param handler   被拦截的控制器对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入了MyInterceptor拦截器的preHandle方法");
        return true;
    }

    /**
     * postHandle : 后处理方法
     * 特点:
     *      1. 在控制器方法执行之后也会执行拦截器
     *      2. 能够获得处理器方法的返回值modelAndView, 可以修改该返回值, 影响最终的返回结果
     * @param request   请求
     * @param response  应答
     * @param handler  被拦截的控制器对象
     * @param modelAndView 处理器方法的返回值
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入了MyInterceptor拦截器的postHandle方法");

    }

    // 不常用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入了MyInterceptor拦截器的afterCompletion方法");

    }
}
