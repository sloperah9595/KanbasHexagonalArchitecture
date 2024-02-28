package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.GetBoardByIdInputPort;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.domain.models.BoardModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetBoardByIdUseCase implements GetBoardByIdInputPort {
    private final BoardOutputPort boardOutputPort;
    
    public BoardModel execute(Integer id){
        return boardOutputPort.findById(id);
    };
}
