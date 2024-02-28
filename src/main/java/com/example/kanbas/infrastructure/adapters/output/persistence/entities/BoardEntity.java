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
@Table(name = "boards")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "bd_id", nullable = false, unique = true)
    private Integer bd_id;


    @Column(name = "bd_name", length = 100, unique = true)
    private String bdName;
    //TODO modificar snake case en java por camel case
    @Column(name = "bd_description", length = 100)
    private String bd_description;

   //TODO: Llamar el entity, y volver le entity un enum
    @Enumerated(EnumType.STRING)
    @Column(name = "bd_status", length = 20)
    private StatusEntity bd_status;

    public BoardEntity(String bd_name, String bd_description, StatusEntity bd_status) {
        this.bdName = bd_name;
        this.bd_description = bd_description;
        this.bd_status = bd_status;
    }

}