package com.example.kanbas.infrastructure.adapters.output.persistence.repositories;

import com.example.kanbas.infrastructure.adapters.output.persistence.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Integer> {
    @Query(value = "SELECT t FROM TaskEntity t WHERE t.id_board.id = :boardId", nativeQuery = true)
    List<TaskEntity> getTaskForBoard(@Param("boardId") Integer boardId);
}
