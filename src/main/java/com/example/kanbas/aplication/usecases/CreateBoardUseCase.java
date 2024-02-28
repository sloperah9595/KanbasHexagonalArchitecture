package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.CreateBoardInputPort;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.domain.exceptions.BoardException;
import com.example.kanbas.domain.models.BoardModel;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateBoardUseCase implements CreateBoardInputPort {
    private final BoardOutputPort boardOutputPort;

    @Override
    public BoardModel execute(String name, String description) {
        Optional<BoardModel> boardCreated = this.boardOutputPort.findByName(name);

        if (boardCreated.isPresent()) {
            throw new BoardException("BoardModel already exists");
        }

        return this.boardOutputPort.save(BoardModel.create(name, description));
    }
}
