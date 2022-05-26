package com.ali.my_take_out.filter;

import com.ali.my_take_out.common.BaseContext;
import com.ali.my_take_out.common.R;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经登录
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求URI
        String requestURI = request.getRequestURI();
        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg", //移动端发送短信
                "/user/login"//移动端登录
        };

        //2、判断本次请求是否需要处理
        boolean check = check(urls, requestURI);
        //3、本次请求不需要处理，直接放行
        if(check){
            filterChain.doFilter(request, response);
            return;
        }

        //4-1、需要处理，判断登录状态 PC端
        if(request.getSession().getAttribute("employee") != null){
            //session中有employee对应的value【此处我们存入的是用户id】，表明已经登录
            log.info("用户已经登录，用户id为：{}", request.getSession().getAttribute("employee"));
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);//使用ThreadLocal保存当前用户id

            filterChain.doFilter(request, response);//放行
            return;

        }

        //4-2、判断登录状态，如果已经登录，直接放行 手机端
        if(request.getSession().getAttribute("user") != null){
            log.info("用户已经登录，用户id为:{}", request.getSession().getAttribute("user"));
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request, response);
            return;
        }
        log.info("用户未登录");


        //5、如果未登录，返回登录结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));//request.js中判断，直接跳转到登录页面
        return;
    }

    /**
     * 判断本次请求是否需要处理
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}






















