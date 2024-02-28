package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.TransitionBoardInputPort;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.domain.exceptions.BoardException;
import com.example.kanbas.domain.models.BoardModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TransitionBoardUseCases implements TransitionBoardInputPort {

    private final BoardOutputPort boardOutputPort;

    public BoardModel execute(Integer id) {
       BoardModel board = this.boardOutputPort.findById(id);
        if (board == null) {
            throw new BoardException("BoardModel not exists");
        }
        return this.boardOutputPort.save(board.transition());
    }
}
