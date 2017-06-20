package br.ideias.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String uf;

    @OneToMany(mappedBy = "estado",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Cidade> cidades;
}
