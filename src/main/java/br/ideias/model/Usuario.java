package br.ideias.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;

    @ManyToOne
    private GrupoUsuario grupoUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Formulario> formularios;
}
