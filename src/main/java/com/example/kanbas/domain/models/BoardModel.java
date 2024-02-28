package com.example.kanbas.domain.models;

import com.example.kanbas.domain.exceptions.BoardException;
import java.util.Objects;


import lombok.Getter;

@Getter
public class BoardModel {
    private static final String NAME_PATTERN = "^[a-zA-Z0-9 ]*$";
    private Integer id;
    private String name;
    private String description;
    private StatusModel status;

    private BoardModel(Integer id, String name, String description, Integer statusId) {
        validateId(id);
        validateName(name);
        validateDescription(description);
        validateStatusId(statusId);

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = StatusModel.findById(statusId);
    }

    private BoardModel(String name, String description, Integer statusId) {
        validateName(name);
        validateDescription(description);
        validateStatusId(statusId);

        this.name = name;
        this.description = description;
        this.status = StatusModel.findById(statusId);
    }

    private void validateId(Integer id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new BoardException("Id is null");
        }
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty() || !name.matches(NAME_PATTERN)) {
            throw new BoardException("Name is invalid");
        }
    }

    private void validateDescription(String description) {
        if (Objects.isNull(description) || description.isEmpty() || !description.matches(NAME_PATTERN)) {
            throw new BoardException("Description is invalid");
        }
    }

    private void validateStatusId(Integer statusId) {
        if (Objects.isNull(statusId)) {
            throw new BoardException("StatusId is null");
        }
    }

    public static BoardModel create(String name, String description) {
        return new BoardModel(name, description, StatusModel.TODO.getId());
    }

    public static BoardModel fromData(Integer id, String name, String description, Integer statusId) {
        return new BoardModel(id, name, description, statusId);
    }

    public BoardModel transition() {
        this.status = StatusModel.transition(this.status.getId());
        return this;
    }

    public BoardModel inactive() {
        this.status = StatusModel.INACTIVE;
        return this;
    }

    public BoardModel active() {
        if (this.status != StatusModel.INACTIVE) {
            throw new BoardException("BoardModel is not inactive");
        }
        this.status = StatusModel.TODO;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardModel that = (BoardModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status);
    }
}


