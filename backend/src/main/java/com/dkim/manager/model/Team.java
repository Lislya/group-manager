package com.dkim.manager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "Team")
@Table(name = "team")
@Data
@EqualsAndHashCode(of = "id")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
