package com.eventorganizr.organizr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "consumables")
@JsonIgnoreProperties({"participantConsumables","events"})
@Data
public class Consumable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumableId;
    private String consumableType;
    private String name;
    private String shortDescription;
//     Ar putea sa mearga, trebuie gasite configurarile
    @OneToMany(mappedBy = "consumable", fetch = FetchType.LAZY)
    @Column(nullable = false, unique = true)
    @JsonManagedReference(value = "participantConsumables")
    private Set<ParticipantConsumable> participantConsumables;

//    @ManyToMany(mappedBy = "consumables", fetch = FetchType.LAZY)
//    @Column(nullable = false)
//    private Set<Event> events;


}
