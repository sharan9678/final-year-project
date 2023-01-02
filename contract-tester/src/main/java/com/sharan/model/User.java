package com.sharan.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (
            strategy = GenerationType.AUTO
    )
    private Long Id;
    private String name;
    private String type;

    public User() {}

    public User(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
