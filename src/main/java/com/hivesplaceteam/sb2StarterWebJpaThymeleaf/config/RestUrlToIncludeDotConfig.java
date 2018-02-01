package com.hivesplaceteam.sb2StarterWebJpaThymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*This configuration is to enable REST API to allow Dot(.) 
 * in the url path
 * e.g. http://localhost:8080/username/jeffrey@gmail.com
 * */
@SuppressWarnings("deprecation")
@Configuration
public class RestUrlToIncludeDotConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// turn off all suffix pattern matching
	    configurer.setUseSuffixPatternMatch(false);
	    // OR
	    // turn on suffix pattern matching ONLY for suffixes
	    // you explicitly register using
	    // configureContentNegotiation(...)
	    /**********
	     * configurer.setUseRegisteredSuffixPatternMatch(true);
	     **********/
	}

	/*Spring assumes the path extension (.html, .txt, etc.) indicates that the resource should be 
	 * returned with a specific format. This behaviour can also be very useful in some situations. 
	 * But often, it will mean that the object returned by a method mapping cannot be converted into this format, 
	 * and Spring will throw a HttpMediaTypeNotAcceptableException
	 * Solution Source: https://stackoverflow.com/questions/27419743/spring-path-variable-truncate-after-dot-annotation
	 * */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}
	
}
