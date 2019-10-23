package com.dkim.manager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Team")
@Table(name = "team")
@Data
@EqualsAndHashCode(of = "id")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer number;

    @ElementCollection(targetClass = Labwork.class)
    private Set<Labwork> labworks;

    @OneToMany(mappedBy = "team")
    private Set<Student> students;
}
