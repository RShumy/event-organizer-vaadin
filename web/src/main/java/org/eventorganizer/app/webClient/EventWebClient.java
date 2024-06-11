package org.eventorganizer.app.webClient;

import org.eventorganizer.app.entity.Event;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EventWebClient {

    WebClient eventWebClient;
    SessionIDResolver sessionIDResolver;
    private static final String BASE_API_URL = "http://localhost:8000/api/";

    EventWebClient(WebClient.Builder eventWebClientBuilder, SessionIDResolver sessionIDResolver){
        this.sessionIDResolver = sessionIDResolver;
        this.eventWebClient = eventWebClientBuilder.baseUrl(BASE_API_URL + "events/").build();
    }

    public List<Event> getAllEvents(){
        return eventWebClient
                .get().uri("all")
                .accept(MediaType.APPLICATION_JSON)
                .header( HttpHeaders.COOKIE, sessionIDResolver.sessionId() )
                .retrieve()
                .bodyToFlux(Event.class)
                .collectList()
                .block();
    }

    public void saveEvent(Event event){
        eventWebClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.COOKIE, sessionIDResolver.sessionId())
                .body(Mono.just(event), Event.class)
                .retrieve().toBodilessEntity()
                .block();
    }

    public void updateEvent(Long id, Event event){
        eventWebClient.put().uri(String.valueOf(id))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.COOKIE, sessionIDResolver.sessionId())
                .body(Mono.just(event), Event.class)
                .retrieve().toBodilessEntity()
                .block();
    }


}
