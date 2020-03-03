package com.keywer.masterclass.spring.graphql.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    @NotNull
    @Column(name = "WATER_TYPE")
    private WaterType waterType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "family")
    private Collection<Fish> fishs;
}