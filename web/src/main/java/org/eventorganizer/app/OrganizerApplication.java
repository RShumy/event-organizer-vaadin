package org.eventorganizer.app;

import org.eventorganizer.app.service.*;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Theme("general")
public class OrganizerApplication extends SpringBootServletInitializer implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}
//	@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//	public class Application {
//		public static void main(String[] args) {
//			SpringApplication.run(OrganizrApplication.class, args);
//		}
//	}

	// Just for insertion purposes only
	@Bean
	CommandLineRunner commandLineRunner(AuthorityService authorityService , UserService userService,
										EventService eventService, ParticipantService participantService,
										ConsumableService consumableService) throws Exception {
		return InitCLR.initialize(authorityService, userService, eventService, participantService, consumableService);
	}
}