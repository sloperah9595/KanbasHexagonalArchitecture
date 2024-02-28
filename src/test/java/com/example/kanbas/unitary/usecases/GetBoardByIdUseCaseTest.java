package com.example.kanbas.unitary.usecases;

import com.example.kanbas.MakeUltis;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.aplication.usecases.CreateBoardUseCase;
import com.example.kanbas.aplication.usecases.GetBoardByIdUseCase;
import com.example.kanbas.domain.models.BoardModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GetBoardByIdUseCaseTest {
    private final Integer BOARD_ID = 1;
    private BoardOutputPort boardOutputPort;
    private GetBoardByIdUseCase getBoardByIdUseCase;

    @BeforeEach
    void setUp() {
        this.boardOutputPort = mock(BoardOutputPort.class);
        this.getBoardByIdUseCase = new GetBoardByIdUseCase(this.boardOutputPort);
    }

    @Test
    void shouldExecuteSuccess() {
        // GIVEN
        BoardModel boardExpected = MakeUltis.makeMockBoard();

        // WHEN
        when(this.boardOutputPort.findById(BOARD_ID)).thenReturn(boardExpected);

        // CALL
        BoardModel result = this.getBoardByIdUseCase.execute(BOARD_ID);

        // THEN - VERIFY
        assertNotNull(result);
        assertEquals(boardExpected, result);
        verify(this.boardOutputPort, times(1)).findById(BOARD_ID);
    }
}

//LiSto tome su test