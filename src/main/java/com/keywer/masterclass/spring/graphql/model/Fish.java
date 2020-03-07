package com.keywer.masterclass.spring.graphql.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fish_generator")
    @SequenceGenerator(name="fish_generator", sequenceName = "fish_seq")
    private long id;
    @NotBlank
    private String name;
    @Positive
    private int temperature;
    @Positive
    @DecimalMin("0.3")
    private float price;
    @NotNull
    @ManyToOne
    @JoinColumn(name="family_fk")
    private Family family;
}
