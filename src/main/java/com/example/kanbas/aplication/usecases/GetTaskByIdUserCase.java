package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.GetTaskByIdInputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.domain.models.TaskModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetTaskByIdUserCase implements GetTaskByIdInputPort {
    private TaskOutputPort taskOutputPort;
    @Override
    public TaskModel execute(Integer id) {
        return taskOutputPort.findById(id);
    }
}
