package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    /*preHandle叫做预处理方法。
    *   参数：
    *   Object handler：被拦截的控制器对象
    *   返回值boolean
    *
    *   特点：
    *       1、方法在控制器方法（StudentController的addStudent）之前执行
    *       用户的请求首先到达此方法
    *
    *       2、在这个 方法中可以获取请求的信息，验证请求是否符合要求。
    *           可以验证用户是否登录，验证用户是否有权限访问某个链接地址（url)
    *               如果验证失败，可以截断请求，请求不能被处理。
    *               如果验证成功，可以放行请求，此时控制器方法才能执行。
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器的MyInterceptor的preHandle（）");
        return true;
    }

    //postHandle 后处理方法
    /*
    * object handler:被拦截的处理器对象Mycontroller
    * ModelAndView modelAndView:处理器方法的返回值
    *特点:
    *   1.在处理器方法之后执行的（Mycontroller. doSome())
    *   2.能够获取到处理器方法的返回值ModelAndView,可以修改ModelAndView中的数据和视图，可以影响到最后的执行结果。
    *   3.主要是对原来的执行结果做二次修正，
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /*
    * afterCompletion:最后执行的方法参数
object handler:被拦截器的处理器对象Exception ex:程序中发生的异常
特点:
1.在请求处理完成后执行的。框架中规定是当你的视图处理完成后，对视图执行了forward。就认为请求处理完成。2.一般做资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收。

    * */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
