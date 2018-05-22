package cn.ideacs.application.woodeasy.config;

import cn.ideacs.application.woodeasy.system.RequestHandlerIntercepter;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author yang
 * @date 17-12-19
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.ideacs.application.woodeasy.controller","cn.ideacs.application.woodeasy.service"})
@Import(WoodEasyDBConfig.class)
public class WoodEasyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 以下三个是配置thymeleaf的试图模式。
     * @param templateEngine
     * @return
     */
    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    /**
     * 设置首页，但是当系统中有index文件的时候。，这个设置就不起作用了，具体原因还未研究明白。
     * 如果不设置这个，也可以新建一个Controller设置“”和"/"的映射，但是存在index的时候也没有作用。
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    /**
     * 以下一个是设置上传文件的视图模式
     */
    @Bean
    public MultipartResolver multipartResolver() {
        MultipartResolver multipartResolver = new StandardServletMultipartResolver();
        return multipartResolver;
    }

    /**
     * 以下是设置json的RESTApi的视图模式
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestHandlerIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login/login");
    }
}
