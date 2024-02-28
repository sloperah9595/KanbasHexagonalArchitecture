package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.GetAllBoardsInputPort;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.domain.exceptions.BoardException;
import com.example.kanbas.domain.models.BoardModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class GetAllBoardUseCase implements GetAllBoardsInputPort {
private BoardOutputPort boardOutputPort;

    @Override
    public List<BoardModel> execute() {
        List<BoardModel> boards = boardOutputPort.findAll();
        if(boards == null || boards.isEmpty()){
            throw new BoardException("Boards not found");
        }
        return boardOutputPort.findAll();
    }
}
