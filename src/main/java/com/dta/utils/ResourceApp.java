package com.dta.utils;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ResourceApp extends ResourceConfig {
	public ResourceApp() {
		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		packages("com.dta.resource");
		new BatchOperation().run();
	}
}