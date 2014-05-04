package com.mountain.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mountain.config.InfrastructureContextConfiguration;
import com.mountain.config.TestDataContextConfiguration;
import com.mountain.web.config.WebMvcContextConfiguration;


/**
 * {@link WebApplicationInitializer} that will be called by Spring's
 * {@code SpringServletContainerInitializer} as part of the JEE
 * {@code ServletContainerInitializer} pattern. This class will be called on
 * application startup and will configure our JEE and Spring configuration.
 * <p/>
 * 
 * It will first initializes our {@code AnnotationConfigWebApplicationContext}
 * with the common {@link Configuration} classes:
 * {@code InfrastructureContextConfiguration} and
 * {@code TestDataContextConfiguration} using a typical JEE
 * {@code ContextLoaderListener}.
 * <p/>
 * 
 * Next it creates a {@link DispatcherServlet}, being a normal JEE Servlet which
 * will create on its turn a child {@code AnnotationConfigWebApplicationContext}
 * configured with the Spring MVC {@code Configuration} classes
 * {@code WebMvcContextConfiguration} and {@code WebflowContextConfiguration}.
 * This Servlet will be registered using JEE's programmatical API support.
 * <p/>
 * 
 * Note: the {@code OpenEntityManagerInViewFilter} is only enabled for pages
 * served solely via Spring MVC. For pages being served via WebFlow we configured
 * WebFlow to use the JpaFlowExecutionListener.
 */
public class MountainWebApplicationInitializer implements
		WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
		ServletRegistration.Dynamic dispatcher;
		dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}
	
	private void registerListener(ServletContext servletContext)
	{
		AnnotationConfigWebApplicationContext rootContext = createContext(InfrastructureContextConfiguration.class, TestDataContextConfiguration.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
	}

	private AnnotationConfigWebApplicationContext createContext(
			final Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}

}
