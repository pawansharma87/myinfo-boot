package net.org.myinfo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/resources/", "classpath:/static/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
/*		registry.addViewController("/user/home").setViewName("home");*/
		registry.addViewController("/").setViewName("index");
		registry.addViewController("**/contactus").setViewName("contactus");
		registry.addViewController("**/aboutus").setViewName("about");
		registry.addViewController("**/gallery").setViewName("gallery");
		registry.addViewController("**/login").setViewName("index");
//		registry.addViewController("/signup").setViewName("signup");
	}

	/*
	 * @Bean ServletRegistrationBean h2servletRegistration(){
	 * ServletRegistrationBean registrationBean = new ServletRegistrationBean(
	 * new WebServlet()); registrationBean.addUrlMappings("/console/*"); return
	 * registrationBean; }
	 */
}