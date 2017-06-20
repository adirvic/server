package br.ideias.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
@Entity
public class GrupoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId("id_cidade")
    @OneToOne
    private Cidade cidade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoUsuario",cascade = CascadeType.ALL)
    private List<Usuario> usuarios;


}
