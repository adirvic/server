package br.ideias.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
@Entity
public class Parte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId("id")
    @OneToOne
    private TipoParte tipoParte;

    @ManyToOne
    @JoinColumn(name = "parte")
    private Formulario formulario;

    private String descricao;

    private int rating;

}
