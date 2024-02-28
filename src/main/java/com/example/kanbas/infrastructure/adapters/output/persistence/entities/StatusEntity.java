package com.example.kanbas.infrastructure.adapters.output.persistence.entities;

import com.example.kanbas.domain.exceptions.StatusException;
import com.example.kanbas.domain.models.StatusModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;

@Getter
@ToString
@NoArgsConstructor
public enum StatusEntity {
    TODO(1, 1, "TODO", "Tareas por hacer"),
    DOING(2, 2, "DOING", "Tareas en progreso"),
    DONE(3, 3, "DONE", "Tareas finalizadas"),
    INACTIVE(4, 0, "INACTIVE", "Tablero inactivo");

    private Integer id;
    private Integer code;
    private String name;
    private String description;

    StatusEntity(Integer id, Integer code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }
    public static StatusEntity findById(Integer id) {
        return Arrays.stream(StatusEntity.values()).filter(
                status -> status.getId().equals(id)
        ).findFirst().orElseThrow(() -> new StatusException("Invalid status id"));
    }

}
