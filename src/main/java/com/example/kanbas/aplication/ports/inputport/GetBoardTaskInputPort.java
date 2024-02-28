package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.TaskModel;

import java.util.List;

public interface GetBoardTaskInputPort {
    List<TaskModel> execute(Integer id);
}
