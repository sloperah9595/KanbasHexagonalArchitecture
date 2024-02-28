package com.example.kanbas.aplication.usecases;

import com.example.kanbas.aplication.ports.inputport.GetBoardTaskInputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.domain.exceptions.TaskException;
import com.example.kanbas.domain.models.TaskModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class GetBoardTaskUseCase implements GetBoardTaskInputPort {
    private TaskOutputPort taskOutputPort;
    @Override
    public List<TaskModel> execute(Integer id) {
        List<TaskModel> tasks = taskOutputPort.getTaskForBoard(id);
        if(tasks == null || tasks.isEmpty()){
            throw  new TaskException("Not  taks found for board with id".concat("1"));
        }
        return tasks ;
    }
}
