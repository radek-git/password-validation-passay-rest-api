package com.radek.gitrepo.config;

import com.radek.gitrepo.annotation.MyPageableHandlerMethodArgumentResolver;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.addAll(List.of(
                new SpecificationArgumentResolver(),
                new MyPageableHandlerMethodArgumentResolver()
        ));
    }

}
