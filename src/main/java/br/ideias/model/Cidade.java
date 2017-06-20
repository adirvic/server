package br.ideias.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by adirvic on 19/06/17.
 */
@Entity
@Data
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
//    @JoinColumn(name = "id_estado")
    private Estado estado;
}
