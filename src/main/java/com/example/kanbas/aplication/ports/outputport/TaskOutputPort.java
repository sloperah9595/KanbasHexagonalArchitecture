package com.example.kanbas.aplication.ports.outputport;

import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.domain.models.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskOutputPort {
    TaskModel save(TaskModel board);
    TaskModel findById(Integer id);
    List<TaskModel> getTaskForBoard(Integer id);

}
