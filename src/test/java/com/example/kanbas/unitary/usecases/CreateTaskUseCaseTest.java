package com.example.kanbas.unitary.usecases;

import com.example.kanbas.MakeUltis;
import com.example.kanbas.aplication.ports.outputport.BoardOutputPort;
import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.aplication.usecases.CreateBoardUseCase;
import com.example.kanbas.aplication.usecases.CreateTaskUseCase;
import com.example.kanbas.domain.models.BoardModel;
import com.example.kanbas.domain.models.TaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CreateTaskUseCaseTest {
    private final Integer BOARD_ID = 1;
    private TaskOutputPort taskOutputPort;
    private BoardOutputPort boardOutputPort;
    private CreateTaskUseCase createTaskUseCase;

    @BeforeEach
    void setUp() {
        this.taskOutputPort = mock(TaskOutputPort.class);
        this.boardOutputPort = mock(BoardOutputPort.class);
        this.createTaskUseCase = new CreateTaskUseCase(this.boardOutputPort,this.taskOutputPort);
    }

    @Test
    void shouldExecuteSuscess() {
        // GIVEN
        TaskModel taskExpected = MakeUltis.makeMockTask();
        BoardModel boardExpected= MakeUltis.makeMockBoard();
        String name = "kanban task";
        String description = "kanban task description";

        // WHEN
        when(this.boardOutputPort.findById(1)).thenReturn(boardExpected);
        when(this.taskOutputPort.save(TaskModel.create(name,description,boardExpected))).thenReturn(taskExpected);

        // CALL
        TaskModel result = this.createTaskUseCase.execute(name, description,BOARD_ID);

        // THEN - VERIFY
        assertNotNull(result);
        assertEquals(taskExpected, result);
        assertEquals(taskExpected.getBoard(),boardExpected);
        verify(this.boardOutputPort, times(1)).findById(BOARD_ID);
        verify(this.taskOutputPort, times(1)).save(TaskModel.create(name,description,boardExpected));
    }
}

//LiSto tome su test