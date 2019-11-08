package com.ea.music.rmgr.handler;


import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class MusicManagerErrorHandler implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	
	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		/*
		 * container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
		 * container.addErrorPages(new ErrorPage("/errorHaven"));
		 * 
		 */}

}
