package com.example.kanbas.infrastructure.configs.mappers;

import com.example.kanbas.domain.models.StatusModel;
import com.example.kanbas.infrastructure.adapters.input.dtos.StatusDTO;
import com.example.kanbas.infrastructure.adapters.output.persistence.entities.StatusEntity;

public class StatusMapper {
    public static StatusDTO toDTO(StatusModel model) {
        return StatusDTO.builder()
                .code(model.getCode())
                .name(model.getName())
                .build();
    }

    public static StatusEntity toEntity(StatusModel model) {
        return StatusEntity.builder()
                .id_status(model.getId())
                .code(model.getCode())
                .name(model.getName())
                .description(model.getDescription())
                .build();
    }

    public static StatusModel toModel(StatusEntity entity) {
        return StatusModel.findById(entity.getId_status());
    }
}
