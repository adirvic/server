package br.ideias.service;

import br.ideias.dto.CidadeDTO;
import br.ideias.model.Cidade;
import br.ideias.repository.CidadeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Component
public class CidadeService {

    @Autowired
    private CidadeRespository cidadeRespository;

    public CidadeDTO findOne(Long id) {
        Cidade one = cidadeRespository.findOne(id);
        return new CidadeDTO(one);
    }

    public List<CidadeDTO> findAll() {
        List<Cidade> all = cidadeRespository.findAll();
        return all.stream().map(CidadeDTO::new).collect(Collectors.toList());
    }

    public CidadeDTO save(CidadeDTO cidadeDto) {
        Cidade save = cidadeRespository.save(cidadeDto.toModel());
        return new CidadeDTO(save);
    }
}
