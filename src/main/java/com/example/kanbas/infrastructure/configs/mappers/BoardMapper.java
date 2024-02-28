package com.example.kanbas.infrastructure.configs.mappers;

import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.infrastructure.adapters.input.dtos.BoardDTO;
import com.example.kanbas.infrastructure.adapters.output.persistence.entities.BoardEntity;

import java.util.List;

public class BoardMapper {

    public static BoardDTO toDTO(BoardModel model) {
        return BoardDTO.builder().id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .status(StatusMapper.toDTO(model.getStatus()))
                .build();
    }

    public static BoardEntity toEntity(BoardModel model) {
        return BoardEntity.builder()
                .bd_id(model.getId())
                .bdName(model.getName())
                .bd_description(model.getDescription())
                .bd_status(StatusMapper.toEntity(model.getStatus()))
                .build();
    }

    public static BoardModel toModel(BoardEntity entity) {
        return BoardModel.fromData(
                entity.getBd_id(),
                entity.getBdName(),
                entity.getBd_description(),
                entity.getBd_status().getId()
        );
    }
    public static List<BoardDTO> toDTOs(List<BoardModel> models) {
        return models.stream().map(BoardMapper::toDTO).toList();
    }
    public static List<BoardModel> toModels(List<BoardEntity> entities) {
        return entities.stream().map(BoardMapper::toModel).toList();
    }
}
