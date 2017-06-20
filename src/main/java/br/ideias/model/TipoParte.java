package br.ideias.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by adirvic on 19/06/17.
 */
@Entity
@Data
public class TipoParte {

    @Id
    @Column(name = "id_tipo_parte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
}
