package com.example.kanbas.infrastructure.adapters.output.persistence.entities;

import com.example.kanbas.domain.models.StatusModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tsk_task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "id_task", nullable = false, unique = true)
    private Integer id_task;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;
    //TODO: Llamar el entity, y volver le entity un enum
    @Enumerated(EnumType.STRING)
    @Column(name = "bd_status", length = 20)
    private StatusEntity id_status;
    @ManyToOne
    @JoinColumn(name = "id_board")
    private BoardEntity idBoard;

    public TaskEntity(String name, String description, StatusEntity id_status, BoardEntity id_board) {
        this.name = name;
        this.description = description;
        this.id_status = id_status;
        this.idBoard = id_board;
    }
}
