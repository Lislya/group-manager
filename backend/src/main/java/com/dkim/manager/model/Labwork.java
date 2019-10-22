package com.dkim.manager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "Labwork")
@Table(name = "labwork")
@Data
@EqualsAndHashCode(of = "id")
public class Labwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;
    private String name;
    private String task;
    private Status status = Status.REGISTERED;
    private final String imgCover = "https://static.wixstatic.com/media/3958fa_1a998cde9eff4124adef2cd8ac6510d7~mv2" +
            ".jpg/v1/fill/w_640,h_682,al_c,q_85,usm_0.66_1.00_0.01/3958fa_1a998cde9eff4124adef2cd8ac6510d7~mv2.webp";

}
