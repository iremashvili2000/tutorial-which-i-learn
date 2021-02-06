package com.goga.cms.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1) //order anotacia gansazgvravs filter tanmimdevrobas
public class MyFilter_3 implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("Filter 3 is called...");
            filterChain.doFilter(servletRequest,servletResponse);

    }
}
