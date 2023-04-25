package com.eventorganizr.organizr.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties({"participants","authorities"})
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean isActive;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonManagedReference(value = "participants")
    Set<Participant> participants;

    @ManyToMany(targetEntity = Authority.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = { @JoinColumn(name = "user_id", insertable = true, updatable = true) },
            inverseJoinColumns = { @JoinColumn(name = "authority_id", insertable = true, updatable = true) }
    )
    @JsonManagedReference(value = "authorities")
    Set<Authority> authorities = new HashSet<>();

    public void addAuthority(Authority authority){
        authorities.add(authority);
    }

    public void removeAuthority(Authority authority){
        authorities.remove(authority);
    }

}
