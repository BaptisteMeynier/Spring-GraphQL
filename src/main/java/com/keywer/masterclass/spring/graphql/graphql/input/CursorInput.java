package com.keywer.masterclass.spring.graphql.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursorInput {
    @Positive
    private int first;
    @Positive
    private int after;
}
