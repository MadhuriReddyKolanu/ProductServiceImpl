package com.example.firstspringapi.representinginheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_user")
//userid as pk for user table that should be able to connect other tables as fk
@PrimaryKeyJoinColumn(name = "user_id")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;

}
