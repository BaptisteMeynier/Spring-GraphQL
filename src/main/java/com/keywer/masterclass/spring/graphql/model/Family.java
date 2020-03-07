package com.keywer.masterclass.spring.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family_generator")
    @SequenceGenerator(name = "family_generator", sequenceName = "family_seq")
    private long id;
    @NotBlank
    private String name;
    @NotNull
    @Column(name = "WATER_TYPE")
    private WaterType waterType;
    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Collection<Fish> fishs;
}