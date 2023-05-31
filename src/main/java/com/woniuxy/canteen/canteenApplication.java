package com.woniuxy.canteen;

import com.woniuxy.canteen.filter.SessionFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@MapperScan("com.woniuxy.canteen.mapper")
@SpringBootApplication
public class canteenApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(canteenApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<SessionFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<SessionFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(sessionFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

    @Bean
    public SessionFilter sessionFilter() {
        return new SessionFilter();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(canteenApplication.class);
    }
}
