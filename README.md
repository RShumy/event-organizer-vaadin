## Event Organizer WIP (Spring Boot - backend, Vaadin - frontend)
## Multi-Module project branch
**NOTE** : Vaadin has issues with newer npm versions <br>
_Consider rolling back npm cli version to 8.5.5 or 8.19.2_ . <br>
You can run `npm install -g npm@8.5.5`

### Back End (Controllers included for Vaadin WebClient(not created yet)) 
#### Simple Event Organizer WebApp. 
Models:
- 4 Base Entity Clases:
	 - Authority, User, Event, Consumable
- 2 Relational Entity Classes:
	 - Participant (n:n) (User, Event) - CompositeKeys/ParticipantKey Class
	 - ParticipantConsumable (n:n) (Participant, Consumable) - CompositeKeys/ParticipantConsumableKey Class
- 2 Relational Entity - declared only by Hibarante @ManyToMany:
	 - EventConsumable (n:n) (Event - owner entity)
	 - UserAuthorities (n:n) (User - owner entity)
#### JPA Repositories
#### Services (SecuritySerivice, AuthorityService, UserService, EventService, ConsumableService ,ParticipantService , PaticipantConsumableService)
#### Spring WebControllers (UserController, EventController, ParticipantController)
#### H2 In-Memory Data Base with Generated, Inserted data.

### Vaadin FrontEnd
- For now Views are calling Service Clasess Directly, Vaadin is auto-routing

### Added Spring Security:
- Added SecuritySerive
- Log-in Page is provided by Spring Security for now
- Created Relational Entity: UserAuthorities (n:n) - declared only by Hibarante @ManyToMany
- Added Password encryption BCrypt
- For learning purposes: Data Base initialization is done via InitCLR extending CommandLineRunner

### JUnit Tests:
- Not a recommended method for testing in production, will have to revise it later

### TO DO:
	- Create EventConsumables list view, selection functionalities and adding to participants
	- Create Participant list view and it's respective Consumables, add/delete consumable functionalities
	- Implement Spring WebClient
	- Create Custom Log-in Page
	- Create Registration Form
	- Implement Method access restricitons
	- Functionalities with invite/join and Event privacy statuses (Public(free, ticket based),Private(free invite only, ticket based))



