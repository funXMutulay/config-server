package org.nioun.essentials.config.server.web.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;



@Configuration
@EnableWebMvc
@ComponentScan("org.nioun.essentials.config.server.*")
public class MvcConfig implements WebMvcConfigurer {

  
   

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

    @Bean  
    public ViewResolver viewResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine);

        

        return viewResolver;
    }

   



	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        String[] STATIC_RESOURCE = {"/","classpath:/**","classpath:/resources/**", "classpath:/resources/static/**",
	                "classpath:/resources/static/js/**","classpath:/resources/static/images/**", "classpath:/resources/static/css/**",
	                "classpath:/static/**"};

	        if (!registry.hasMappingForPattern("/**")) {
	            registry.addResourceHandler("/**").addResourceLocations(STATIC_RESOURCE);
	        }
	    }

 
	
}
