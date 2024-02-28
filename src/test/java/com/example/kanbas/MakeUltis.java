package com.example.kanbas;

import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.domain.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class MakeUltis {

    public static BoardModel makeMockBoard() {
        return BoardModel.fromData(1, "kanban", "kanban description", 1);
    }
    public static TaskModel makeMockTask() {
        return TaskModel.fromData(1, "kanban task", "kanban task description",makeMockBoard(), 1);
    }
    public static List<TaskModel> makeMockListTask() {
        List<TaskModel> tasks = new ArrayList<>();
        tasks.add(makeMockTask());
        return tasks;
    }
}
