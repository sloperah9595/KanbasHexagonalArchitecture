package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.TaskModel;

public interface CreateTaskInputPort {
    TaskModel execute(String name,String Description,Integer idBoard);
}
