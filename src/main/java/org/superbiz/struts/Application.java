package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "SiteMeshFilter")
    FilterRegistrationBean myFilterRegistration () {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new SiteMeshFilter());
        frb.setUrlPatterns(Arrays.asList("/*"));
        return frb;
    }

    @Bean(name = "StrutsPrepareAndExecuteFilter")
    FilterRegistrationBean mStrutsFilterRegistration () {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new StrutsPrepareAndExecuteFilter());
        frb.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action",
                "/listAllUsers.action");
        frb.setUrlPatterns(Arrays.asList("/*"));
        return frb;
    }
}
