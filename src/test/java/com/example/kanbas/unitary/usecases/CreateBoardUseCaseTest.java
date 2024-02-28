package com.example.kanbas.unitary.usecases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.kanbas.MakeUltis;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.aplication.usecases.CreateBoardUseCase;
import com.example.kanbas.domain.models.BoardModel;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateBoardUseCaseTest {

    private BoardOutputPort boardOutputPort;
    private CreateBoardUseCase createBoardUseCase;

    @BeforeEach
    void setUp() {
        this.boardOutputPort = mock(BoardOutputPort.class);
        this.createBoardUseCase = new CreateBoardUseCase(this.boardOutputPort);
    }

    @Test
    void shouldExecuteSuscess() {
        // GIVEN
        BoardModel boardExpected = MakeUltis.makeMockBoard();
        String name = "kanban";
        String description = "kanban description";

        // WHEN
        when(this.boardOutputPort.findByName(name)).thenReturn(Optional.empty());
        when(this.boardOutputPort.save(BoardModel.create(name, description))).thenReturn(boardExpected);

        // CALL
        BoardModel result = this.createBoardUseCase.execute(name, description);

        // THEN - VERIFY
        assertNotNull(result);
        assertEquals(boardExpected, result);
        verify(this.boardOutputPort, times(1)).findByName(name);
        verify(this.boardOutputPort, times(1)).save(BoardModel.create(name, description));
    }
}

//LiSto tome su test