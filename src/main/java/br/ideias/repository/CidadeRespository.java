package br.ideias.repository;

import br.ideias.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adirvic on 19/06/17.
 */
public interface CidadeRespository extends JpaRepository<Cidade,Long>{

}
