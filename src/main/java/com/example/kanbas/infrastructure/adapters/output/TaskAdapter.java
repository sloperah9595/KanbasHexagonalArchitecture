package com.example.kanbas.infrastructure.adapters.output;

import com.example.kanbas.aplication.ports.outputport.TaskOutputPort;
import com.example.kanbas.domain.exceptions.TaskException;
import com.example.kanbas.domain.models.TaskModel;
import com.example.kanbas.infrastructure.adapters.output.persistence.entities.TaskEntity;
import com.example.kanbas.infrastructure.adapters.output.persistence.repositories.TaskJpaRepository;
import com.example.kanbas.infrastructure.configs.mappers.TaskMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TaskAdapter implements TaskOutputPort {
    private final TaskJpaRepository jpaRepository;
    @PersistenceContext
    private EntityManager entityManager;
    public TaskAdapter(TaskJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public TaskModel save(TaskModel task) {
        return TaskMapper.toModel(
                this.jpaRepository.save(
                        TaskMapper.toEntity(task)
                )
        );
    }

    @Override
    public TaskModel findById(Integer id) {
        Optional<TaskEntity> taskEntity = jpaRepository.findById(id);
        if (taskEntity.isEmpty()) {
            throw new TaskException("Task not found");
        }
        return  TaskMapper.toModel(taskEntity.get());
    }

    @Override
    public List<TaskModel> getTaskForBoard(Integer boardId) {
        //TODO patron CQRS, cambiar por @Query con jpa
        return TaskMapper.toModels(
                entityManager.createQuery(
                        "SELECT t FROM TaskEntity t WHERE t.idBoard.id = :boardId", TaskEntity.class)
                .setParameter("boardId", boardId)
                .getResultList()
        );
    }


}
