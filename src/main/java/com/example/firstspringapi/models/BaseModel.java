package com.example.firstspringapi.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
// mappedsuperclass is to maintain inheritance between product/category and basemodel
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private long Id;
    private Date createdAt;
    private Date modifiedAt;
}
