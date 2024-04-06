package com.example.firstspringapi.representinginheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
//userid as pk for user table that should be able to connect other tables as fk
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    private String specialization;
}
