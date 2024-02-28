package com.example.kanbas.infrastructure.configs.mappers;

import com.example.kanbas.domain.models.TaskModel;
import com.example.kanbas.infrastructure.adapters.input.dtos.TaskDTO;
import com.example.kanbas.infrastructure.adapters.output.persistence.entities.TaskEntity;

import java.util.List;

public class TaskMapper {

    public static TaskDTO toDTO(TaskModel model) {

        return TaskDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .status(StatusMapper.toDTO(
                        model.getStatus()
                        )
                )
                .board(BoardMapper.toDTO(
                        model.getBoard()
                        )
                )
                .build();
    }

    public static TaskEntity toEntity(TaskModel model) {
        return TaskEntity.builder()
                .id_task(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .id_status(StatusMapper.toEntity(model.getStatus()))
                .idBoard(BoardMapper.toEntity(
                        model.getBoard()
                        )
                )
                .build();
    }

    public static TaskModel toModel(TaskEntity entity) {
        return TaskModel.fromData(
                entity.getId_task()
                ,entity.getName()
                ,entity.getDescription()
                ,BoardMapper.toModel(
                        entity.getIdBoard()
                )
                ,entity.getId_status().getId());
    }
    public static List<TaskModel> toModels(List<TaskEntity> entities) {
        return entities.stream().map(TaskMapper::toModel).toList();
    }
    public static List<TaskDTO> toDTOs(List<TaskModel> model) {
        return model.stream().map(TaskMapper::toDTO).toList();
    }
}
