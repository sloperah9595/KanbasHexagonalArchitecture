package com.example.kanbas.infrastructure.adapters.output;

import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.domain.exceptions.BoardException;
import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.infrastructure.adapters.output.persistence.entities.BoardEntity;
import com.example.kanbas.infrastructure.adapters.output.persistence.repositories.BoardJpaRepository;
import com.example.kanbas.infrastructure.configs.mappers.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Repository
public class BoardAdapter implements BoardOutputPort {
    private final BoardJpaRepository jpaRepository;

    public BoardAdapter(BoardJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public BoardModel save(BoardModel board) {
        return BoardMapper.toModel(
                this.jpaRepository.save(
                        BoardMapper.toEntity(board)
                )
        );
    }

    @Override
    public Optional<BoardModel> findByName(String name) {
        Optional<BoardEntity> boardEntity = jpaRepository.findByBdName(name);
        if (Objects.isNull(boardEntity) || boardEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(BoardMapper.toModel(boardEntity.get()));
    }

    @Override
    public BoardModel findById(Integer id) {
        Optional<BoardEntity> boardEntity = jpaRepository.findById(id);
        if (boardEntity.isEmpty()) {
            throw new BoardException("Board not found");
        }
        return  BoardMapper.toModel(boardEntity.get());
    }

    @Override
    public List<BoardModel> findAll() {
        List<BoardEntity> boards = jpaRepository.findAll();
        if (boards.isEmpty()) {
            throw new BoardException("Boards not found");
        }
        return BoardMapper.toModels(boards);
    }
}
