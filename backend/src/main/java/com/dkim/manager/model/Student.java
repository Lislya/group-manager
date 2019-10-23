package com.dkim.manager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "Student")
@Table(name = "student")
@Data
public class Student extends User {
    private String faculty;
    private String studyGroup;
    private Integer course;

    @ManyToOne
    @JoinColumn
    private Team team;
}
