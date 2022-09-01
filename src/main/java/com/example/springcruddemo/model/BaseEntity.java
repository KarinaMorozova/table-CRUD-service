package com.example.springcruddemo.model;

import lombok.Data;

import javax.persistence.*;


@Entity
public class BaseEntity {
    @Id
    private Long id;
}
