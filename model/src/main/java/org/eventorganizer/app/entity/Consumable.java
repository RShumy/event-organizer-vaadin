package org.eventorganizer.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "consumables")
@JsonIgnoreProperties({"participantConsumables","events"})
@Data
public class Consumable {

    public Consumable(){}
    public Consumable(String consumableType, String name, String shortDescription) {
        this.consumableType = consumableType;
        this.name = name;
        this.shortDescription = shortDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumableId;
    private String consumableType;
    private String name;
    private String shortDescription;

    @OneToMany(mappedBy = "consumable", fetch = FetchType.LAZY)
    @Column(nullable = false, unique = true)
    @JsonManagedReference(value = "participantConsumables")
    private Set<ParticipantConsumable> participantConsumables;



//    @ManyToMany(mappedBy = "consumables", fetch = FetchType.LAZY)
//    @Column(nullable = false)
//    private Set<Event> events;


}
