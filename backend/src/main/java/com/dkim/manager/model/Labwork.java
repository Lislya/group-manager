package com.dkim.manager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "Labwork")
@Table(name = "labwork")
@Data
@EqualsAndHashCode(of = "id")
public class Labwork {
    @Id
    private Long id;

    public Labwork(Long id) {
        this.id = id;
    }

    private String name;
    private String task;
    private Status status;
    private LocalDate deadline;

}
