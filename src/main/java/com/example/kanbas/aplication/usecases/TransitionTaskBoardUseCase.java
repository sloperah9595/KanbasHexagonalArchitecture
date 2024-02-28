package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.TransitionTaskInputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.domain.exceptions.TaskException;
import com.example.kanbas.domain.models.TaskModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransitionTaskBoardUseCase implements TransitionTaskInputPort {
private TaskOutputPort taskOutputPort;
    @Override
    public TaskModel execute(Integer id) {
        TaskModel task = this.taskOutputPort.findById(id);
        if (task == null) {
            throw new TaskException("Task not exists");
        }
        return this.taskOutputPort.save(task.transition());
    }
}
