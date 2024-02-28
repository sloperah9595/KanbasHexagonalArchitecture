package com.example.kanbas.aplication.ports.inputport;

import com.example.kanbas.domain.models.BoardModel;

public interface TransitionBoardInputPort {

    BoardModel execute(Integer id);
}
