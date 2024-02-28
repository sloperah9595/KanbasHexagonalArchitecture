package com.example.kanbas.unitary.usecases;

import com.example.kanbas.MakeUltis;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.aplication.usecases.CreateTaskUseCase;
import com.example.kanbas.aplication.usecases.GetBoardTaskUseCase;
import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.domain.models.TaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetBoardTaskUseCaseTest {
    private final Integer BOARD_ID = 1;
    private TaskOutputPort taskOutputPort;
    private GetBoardTaskUseCase getBoardTaskUseCase;

    @BeforeEach
    void setUp() {
        this.taskOutputPort = mock(TaskOutputPort.class);
        this.getBoardTaskUseCase = new GetBoardTaskUseCase(this.taskOutputPort);
    }

    @Test
    void shouldExecuteSuscess() {
        // GIVEN
        List<TaskModel> tasksExpected = MakeUltis.makeMockListTask();

        // WHEN
        when(this.taskOutputPort.getTaskForBoard(BOARD_ID)).thenReturn(tasksExpected);

        // CALL
        List<TaskModel> result = this.getBoardTaskUseCase.execute(BOARD_ID);

        // THEN - VERIFY
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.contains(MakeUltis.makeMockTask()));
        assertEquals(1, result.size());
        verify(this.taskOutputPort, times(1)).getTaskForBoard(BOARD_ID);
    }
}

//LiSto tome su test