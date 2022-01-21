package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller：创建处理器对象，对象放在springmvc容器中
@Controller
public class MyController {
    /*
    * 准备使用doSome方法处理some.do请求.
    * @RequestMapping:请求映射,作用是把一个请求地址和一个方法绑定在一起.
    *                   一个请求指定一个方法处理
    * */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){//doGet() --service请求处理
        //处理some.do请求了。相当于service调用完成了.
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域.
        //request.setAttribute("msg","欢迎使用springmvc做web开发");
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图,指定视图的完整路径
        //框架对视图执行的是forward操作,request.getRequestDispatcher("/show.jsp").forward(....)
       // mv.setViewName("/show.jsp");

        //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀+逻辑名称+后缀 组成完整路径，这里就是字符连接操作
        //WEB-INF/view/+show+.jsp
        mv.setViewName("show");
        return mv;
    }
}
