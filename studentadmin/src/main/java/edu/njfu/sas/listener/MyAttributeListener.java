package edu.njfu.sas.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class MyAttributeListener implements
        ServletContextAttributeListener,
        HttpSessionAttributeListener,
        ServletRequestAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object attribute = servletContextAttributeEvent.getServletContext().getAttribute(name);
        System.out.println("servletcontect 添加属性 "+name+"="+attribute);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
//        Object attribute = servletContextAttributeEvent.getServletContext().getAttribute(name);
        System.out.println("servletcontect 移除属性 "+name);

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
//        Object attribute = httpSessionBindingEvent.getSession().getAttribute(name);
        System.out.println("session 移除属性 "+name);

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        Object attribute = httpSessionBindingEvent.getSession().getAttribute(name);
        System.out.println("session 添加属性 "+name+"="+attribute);

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        Object attribute = httpSessionBindingEvent.getSession().getAttribute(name);
        System.out.println("session 替换 "+name+"="+attribute);

    }
}
