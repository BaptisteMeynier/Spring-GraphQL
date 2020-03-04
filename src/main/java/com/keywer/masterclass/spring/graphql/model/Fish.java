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
@EqualsAndHashCode
public class Fish implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    @Positive
    private int temperature;
    @Positive
    @DecimalMin("0.3")
    private float price;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="family_fk")
    private Family family;
}