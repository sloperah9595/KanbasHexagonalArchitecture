package com.example.kanbas.infrastructure.adapters.input.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//TODO: Crear DTO sin el ids
public class TaskDTO {
    private Integer id;
    private String name;
    private String description;
    private StatusDTO status;
    private BoardDTO board;
    private Integer board_id;
}
