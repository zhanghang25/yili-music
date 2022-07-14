package com.edu.yilimusic.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Role extends  AbstractEntity{
    private String name = "ROLE_USER";

    private String title ;



}
