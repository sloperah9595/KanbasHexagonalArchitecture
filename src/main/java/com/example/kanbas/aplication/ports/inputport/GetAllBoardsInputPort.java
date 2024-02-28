package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.BoardModel;

import java.util.List;

public interface GetAllBoardsInputPort {
    List<BoardModel> execute();
}
