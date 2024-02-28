package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.TaskModel;

public interface TransitionTaskInputPort {
    TaskModel execute(Integer id);
}
