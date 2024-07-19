package com.prueba.tecnica.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String dimension;

    @ElementCollection
    @CollectionTable(name = "location_residents", joinColumns = @JoinColumn(name = "location_id"))
    @Column(name = "resident_url")
    private List<String> residents;

    private String url;
    private String created;
}
