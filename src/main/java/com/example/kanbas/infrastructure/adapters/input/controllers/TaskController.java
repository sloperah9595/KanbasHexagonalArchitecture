package com.example.kanbas.infrastructure.adapters.input.controllers;

import com.example.kanbas.aplication.ports.inputport.CreateTaskInputPort;
import com.example.kanbas.aplication.ports.inputport.GetBoardTaskInputPort;
import com.example.kanbas.aplication.ports.inputport.GetTaskByIdInputPort;
import com.example.kanbas.aplication.ports.inputport.TransitionTaskInputPort;
import com.example.kanbas.infrastructure.adapters.input.dtos.TaskDTO;
import com.example.kanbas.infrastructure.configs.mappers.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
 private GetTaskByIdInputPort getTaskByIdInputPort;
 private CreateTaskInputPort createTaskInputPort;
 private TransitionTaskInputPort transitionTaskInputPort;
 private GetBoardTaskInputPort getBoardTaskInputPort;



    @GetMapping("/{id}")
    ResponseEntity<TaskDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(TaskMapper.toDTO(getTaskByIdInputPort.execute(id)), HttpStatus.OK);
    }
//TODO: quitar el id del board del body y ponerlo en el request
    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO tasKDTO) {
        return new ResponseEntity<>(TaskMapper.toDTO(
                createTaskInputPort.execute(
                        tasKDTO.getName()
                        ,tasKDTO.getDescription()
                        ,tasKDTO.getBoard_id()
                )
        ),
                HttpStatus.CREATED
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> taskTransition(@PathVariable Integer id) {
        return new ResponseEntity<>(TaskMapper.toDTO(
                this.transitionTaskInputPort.execute(id)
        ),
                HttpStatus.OK
        );
    }
    @GetMapping("taskByBoard/{id}")
    public ResponseEntity<List<TaskDTO>> getBoardTask(@PathVariable Integer id) {
        return new ResponseEntity<>(TaskMapper.toDTOs(
                this.getBoardTaskInputPort.execute(id)
        ),
                HttpStatus.OK
        );
    }

}
