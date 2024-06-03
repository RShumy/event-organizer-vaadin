package org.eventorganizer.app.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorityId;
    @Column(unique = true)
    private String name;

    public Authority(){}

    public Authority(String name){
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
