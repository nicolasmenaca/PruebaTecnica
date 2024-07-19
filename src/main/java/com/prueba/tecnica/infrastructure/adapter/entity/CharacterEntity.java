package com.prueba.tecnica.infrastructure.adapter.entity;

import com.prueba.tecnica.domain.model.LocationModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "origin")
    private LocationEntity origin;

    @ManyToOne
    @JoinColumn(name = "location")
    private LocationEntity location;

    private String image;

    @ElementCollection
    @CollectionTable(name = "character_episodes", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "episode")
    private List<String> episode;

    private String url;
    private String created;
}
