package com.example.kanbas.domain.models;

import com.example.kanbas.domain.exceptions.TaskException;
import lombok.Getter;
import java.util.Objects;

@Getter

public class TaskModel {
    private static final String NAME_PATTERN = "^[a-zA-Z0-9 ]*$";
    private Integer id;
    private String name;
    private String description;
    private StatusModel status;
    private BoardModel board;

    private TaskModel(String name, String description, BoardModel board, Integer statusId) {
        validateName(name);
        validateDescription(description);
        validateStatusId(statusId);
        validateBoard(board);

        this.name = name;
        this.description = description;
        this.board = board;
        this.status = StatusModel.findById(statusId);
    }
    private TaskModel(Integer id ,String name, String description, BoardModel board, Integer statusId) {
        validateId(id);
        validateName(name);
        validateDescription(description);
        validateStatusId(statusId);
        validateBoard(board);

        this.id = id;
        this.name = name;
        this.description = description;
        this.board = board;
        this.status = StatusModel.findById(statusId);
    }

    public static TaskModel create(String name, String description,BoardModel board){
        return new TaskModel(name, description,board,StatusModel.TODO.getId());
    }

    public static TaskModel fromData(Integer id, String name, String description,BoardModel board,Integer statusId) {
        return new TaskModel(id, name, description, board ,statusId);
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty() || !name.matches(NAME_PATTERN)) {
            throw new TaskException("Name is invalid");
        }
    }

    private void validateDescription(String description) {
        if (Objects.isNull(description) || description.isEmpty() || !description.matches(NAME_PATTERN)) {
            throw new TaskException("Description is invalid");
        }
    }
    private void validateId(Integer id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new TaskException("Id is null");
        }
    }
    private void validateStatusId(Integer statusId) {
        if (Objects.isNull(statusId)) {
            throw new TaskException("StatusId is null");
        }
    }
    private void validateBoard(BoardModel board) {
        if (Objects.isNull(board)) {
            throw new TaskException("A board for a task cant be null");
        }
    }
    public TaskModel transition() {
        this.status = StatusModel.transition(this.status.getId());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(id, taskModel.id) && Objects.equals(name, taskModel.name) && Objects.equals(description, taskModel.description) && status == taskModel.status && Objects.equals(board, taskModel.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, board);
    }
}
