package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.BoardModel;

public interface GetBoardByIdInputPort {
    BoardModel execute(Integer id);
}
