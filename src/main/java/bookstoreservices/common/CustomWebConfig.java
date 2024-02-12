package bookstoreservices.common;

import bookstoreservices.config.JwtInterceptor;
import bookstoreservices.config.JwtInterceptors;
import bookstoreservices.dto.RequestMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;
//    @Autowired
//    private JwtInterceptors jwtInterceptors;

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //sort
        SortHandlerMethodArgumentResolver sortResolver=new SortHandlerMethodArgumentResolver();
        sortResolver.setSortParameter("order-by");

        //page
        PageableHandlerMethodArgumentResolver pageResolver=new PageableHandlerMethodArgumentResolver(sortResolver);
        pageResolver.setPageParameterName("page-number");
        pageResolver.setSizeParameterName("page-size");
        pageResolver.setOneIndexedParameters(true);//1 index la irunthu paraameter  kudukkalaam

//        Pageable.ofSize(5);
        Pageable defaultPageable= PageRequest.of(0, 5);
        pageResolver.setFallbackPageable(defaultPageable);

        resolvers.add(pageResolver);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) { //ithuthaan connect pannuthu interseptor ah
        registry.addInterceptor(jwtInterceptor);
//        registry.addInterceptor(jwtInterceptors);

    }


    @Bean
    @RequestScope //    @Scope(value ="request",proxyMode = ScopedProxyMode.TARGET_CLASS) OR
    public RequestMeta getRequestMeta(){
        return new RequestMeta();
    }

//    @Bean
//    public JwtInterceptor jwtInterceptor(){
//       return new JwtInterceptor(getRequestMeta());
//    }
}
