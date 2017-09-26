package com.llc.conf;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Order(2)
public class CommonInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //filter
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //druid
        WebStatFilter duridFilter = new WebStatFilter();
        MockFilterConfig mfc = new MockFilterConfig("DruidWebStatFilter");
        mfc.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.jsp,/druid/*,/download/*");
        mfc.addInitParameter("sessionStatMaxCount", "2000");
        mfc.addInitParameter("sessionStatEnable", "true");
        mfc.addInitParameter("principalSessionName", "session_user_key");
        mfc.addInitParameter("profileEnable", "true");
        duridFilter.init(mfc);
        FilterRegistration.Dynamic encoding = servletContext.addFilter("encodingFilter", characterEncodingFilter);
        FilterRegistration.Dynamic druid = servletContext.addFilter("DruidWebStatFilter", duridFilter);
        druid.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");
        encoding.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");
        //servlet
        StatViewServlet druidServlet=new StatViewServlet();
        ServletRegistration.Dynamic druids = servletContext.addServlet("DruidStatView", druidServlet);
        druids.setLoadOnStartup(2);
        druids.addMapping("/druid/*");
    }
}
