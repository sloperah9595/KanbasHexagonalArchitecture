package com.example.kanbas.infrastructure.adapters.input.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//TODO: Crear DTO sin el ids
public class BoardDTO {
    private Integer id;
    private String name;
    private String description;
    private StatusDTO status;
}
