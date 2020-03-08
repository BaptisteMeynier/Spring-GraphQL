package com.keywer.masterclass.spring.graphql.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationInput {
    @Positive
    private int first;
    @PositiveOrZero
    private int offset;
}
