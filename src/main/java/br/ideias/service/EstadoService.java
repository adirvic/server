package br.ideias.service;

import br.ideias.dto.EstadoDTO;
import br.ideias.model.Estado;
import br.ideias.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Component
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoDTO save(EstadoDTO estadoDTO){
        Estado estado = estadoRepository.save(estadoDTO.toModel());
        return new EstadoDTO(estado);
    }

    public EstadoDTO findOne(Long id) {
        Estado one = estadoRepository.findOne(id);
        return new EstadoDTO(one);
    }


    public List<EstadoDTO> findAll() {
        List<Estado> all = estadoRepository.findAll();
        List<EstadoDTO> collect = all.stream().map(EstadoDTO::new).collect(Collectors.toList());
        return collect;
    }


}
