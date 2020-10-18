package com.groupal.libreriaPrismaBackend.security;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ResourceProperties resourceProperties = new ResourceProperties();

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        long cachePeriod = resourceProperties.getCache().getPeriod().getSeconds();

        final String[] staticLocations = resourceProperties.getStaticLocations();
        System.out.println(staticLocations);
        final String[] indexLocations = new String[staticLocations.length];
        for (int i = 0; i < staticLocations.length; i++) {
            indexLocations[i] = staticLocations[i] + "index.html";
            System.out.println(indexLocations[i]);
        }

        registry.addResourceHandler(
        		"/**",
                "/**/*.css",
                "/**/*.js")
                .addResourceLocations(staticLocations);

        registry.addResourceHandler(
        		 "/**/*.css",
        	      "/**/*.html",
        	      "/**/*.js",
        	      "/**/*.json",
        	      "/**/*.bmp",
        	      "/**/*.jpeg",
        	      "/**/*.jpg",
        	      "/**/*.gif",
        	      "/**/*.ico",
        	      "/**/*.png",
        	      "/**/*.ttf",
        	      "/**/*.wav",
        	      "/**/*.mp3",
        	      "/**/*.eot",
        	      "/**/*.svg",
        	      "/**/*.woff",
        	      "/**/*.woff2",
        	      "/**/*.map")
                .addResourceLocations(staticLocations)
                .setCacheControl(CacheControl.maxAge(600, TimeUnit.SECONDS));

        registry.addResourceHandler("/**")
                .addResourceLocations(indexLocations)
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) {
                        return location.exists() && location.isReadable() ? location : null;
                    }
                });
    }
    
    public void addCorsMapping(CorsRegistry registry) {
    	registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","HEAD");
    }
    
    
}