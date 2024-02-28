package com.example.kanbas.aplication.ports.outputport;

import com.example.kanbas.domain.models.BoardModel;


import java.util.List;
import java.util.Optional;

public interface BoardOutputPort {
    BoardModel save(BoardModel board);

    Optional<BoardModel> findByName(String name);
    
    BoardModel findById(Integer id);

    List<BoardModel> findAll();
}