package com.example.firstspringapi.representinginheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// to change name of table give name eqaul to
@Entity(name = "msc_instructor")
public class Instructor extends  User{
    private String specialization;
}
