## Event Organizer WIP (Spring Boot - backend, Vaadin - frontend)
**NOTE** : Vaadin has issues with newer npm versions <br>
_Consider rolling back npm cli version to 8.5.5 or 8.19.2_ . <br>
You can run `npm install -g npm@8.5.5`
### Back End (Controlers included for Vaadin WebClient(not created yet)) 
#### Simple Event Organizer WebApp. 
Models:
- 3 Base Entity Clases:
	 - User, Event, Consumable
- 2 Relational Entity Classes:
	 - Participant (n:n) (User, Event) - CompositeKeys/ParticipantKey Class
	 - ParticipantConsumable (n:n) (Participant, Consumable) - CompositeKeys/ParticipantConsumableKey Class
- 2 Relational Entity - declared only by Hibarante @ManyToMany:
	 - EventConsumable (n:n) (Event - owner entity)
	 - UserAuthorities (n:n) (User - owner entity)
#### JPA Repositories
#### Services (UserService, EventService, ConsumableService ,ParticipantService , PaticipantConsumableService)
#### Spring WebControllers (UserController, EventController, ParticipantController)
#### H2 In-Memory Data Base with Generated, Inserted data.

### Vaadin FrontEnd
- For now Views are calling Service Clasess Directly, Vaadin is auto-routing

### Added Spring Security:
- Added only Authority entity
- Created Relational Entity: UserAuthorities (n:n) - declared only by Hibarante @ManyToMany
- Log-in Page is provided by Spring Security for now

### TO DO:
	- Create EventConsumables list view, selection functionalities and adding to participants
	- Create Participant list view and it's respective Consumables, add/delete consumable functionalities
	- Implement Vaadin WebClient
	- Create Custom Log-in Page
	- Create Registration Form
	- Implement Method access restricitons
	- Functionalities with invite/join and Event privacy statuses (Public(free, ticket based),Private(free invite only, ticket based))
	- Figure out a solution to make login POST request test with Postman work, after excluding .httpbasic() from SecurityFilterChain
	



