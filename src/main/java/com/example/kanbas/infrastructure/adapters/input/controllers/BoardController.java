package com.example.kanbas.infrastructure.adapters.input.controllers;

import com.example.kanbas.aplication.ports.inputport.CreateBoardInputPort;
import com.example.kanbas.aplication.ports.inputport.GetAllBoardsInputPort;
import com.example.kanbas.aplication.ports.inputport.GetBoardByIdInputPort;
import com.example.kanbas.aplication.ports.inputport.TransitionBoardInputPort;
import com.example.kanbas.infrastructure.configs.mappers.BoardMapper;
import com.example.kanbas.infrastructure.adapters.input.dtos.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final CreateBoardInputPort createBoardInputPort;
    private final GetAllBoardsInputPort getAllBoardsInputPort;
    private final GetBoardByIdInputPort getBoardByIdInputPort;
    private final TransitionBoardInputPort transitionBoardInputPort;
    @PostMapping
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO newBoard) {
        return new ResponseEntity<>(BoardMapper.toDTO(
                this.createBoardInputPort.execute(newBoard.getName(), newBoard.getDescription())
        ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAll() {
        return new ResponseEntity<>(BoardMapper.toDTOs(
                this.getAllBoardsInputPort.execute()
        ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<BoardDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(BoardMapper.toDTO(
                getBoardByIdInputPort.execute(id)
        ),
                HttpStatus.OK
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BoardDTO> updateBoardById(@PathVariable  @NonNull  Integer id) {
        return new ResponseEntity<>(BoardMapper.toDTO(
                this.transitionBoardInputPort.execute(id)
        ),
                HttpStatus.OK
        );
    }
}
