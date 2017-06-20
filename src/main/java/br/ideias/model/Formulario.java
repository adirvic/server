package br.ideias.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
@Entity
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formulario",cascade = CascadeType.ALL)
    private List<Parte> partes;

}
