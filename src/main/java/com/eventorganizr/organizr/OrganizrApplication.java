package com.eventorganizr.organizr;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Theme("general")
public class OrganizrApplication extends SpringBootServletInitializer implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(OrganizrApplication.class, args);
	}
	@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
	public class Application {
		public static void main(String[] args) {
			SpringApplication.run(OrganizrApplication.class, args);
		}
	}
}