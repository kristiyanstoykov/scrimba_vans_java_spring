package com.vans.vans.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vans")
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    @Column(length = 5000)
    private String description;
    private String imageUrl;
    private String type;

    private Long hostId;

}
