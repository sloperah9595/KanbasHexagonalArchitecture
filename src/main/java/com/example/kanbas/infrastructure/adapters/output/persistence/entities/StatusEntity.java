package com.example.kanbas.infrastructure.adapters.output.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tsk_status")
public class StatusEntity {

    private Integer id_status;
    private Integer code;
    private String name;
    private String description;
    public StatusEntity(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

}
