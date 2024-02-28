package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.BoardModel;

public interface CreateBoardInputPort {
    BoardModel execute(String name, String description);
}
