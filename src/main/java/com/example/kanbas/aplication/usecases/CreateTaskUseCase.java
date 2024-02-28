package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.CreateTaskInputPort;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.domain.models.TaskModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTaskUseCase implements CreateTaskInputPort {
    private final BoardOutputPort boardOutputPort;
    private final TaskOutputPort taskOutputPort;
    @Override
    public TaskModel execute(String name, String description, Integer idBoard) {
        BoardModel board = boardOutputPort.findById(idBoard);
        return taskOutputPort.save(TaskModel.create(name,description,board));
    }
}
