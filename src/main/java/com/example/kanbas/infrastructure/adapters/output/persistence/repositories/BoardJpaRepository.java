package com.example.kanbas.infrastructure.adapters.output.persistence.repositories;

import com.example.kanbas.infrastructure.adapters.output.persistence.entities.BoardEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BoardJpaRepository extends JpaRepository<BoardEntity, Integer> {
    Optional<BoardEntity> findByBdName(String bd_name);

}
