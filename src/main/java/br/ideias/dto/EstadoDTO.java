package br.ideias.dto;

import br.ideias.model.Cidade;
import br.ideias.model.Estado;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class EstadoDTO implements BaseDTO<Estado> {

    private Long id;
    private String nome;
    private String uf;
    private List<CidadeDTO> cidades;

    public EstadoDTO() {
    }

    public EstadoDTO(Estado estado) {
        troca(estado::getId,this::setId);
        troca(estado::getNome,this::setNome);
        troca(estado::getUf,this::setUf);

        if (estado.getCidades() != null) {
            List<CidadeDTO> collect = estado.getCidades()
                    .stream()
                    .map(CidadeDTO::new)
                    .collect(Collectors.toList());

            setCidades(collect);
        }

    }

    @Override
    public Estado toModel() {
        Estado estado = new Estado();

        troca(this::getId, estado::setId);
        troca(this::getNome, estado::setNome);
        troca(this::getUf, estado::setUf);

        if(getCidades() != null) {
            List<Cidade> collect = getCidades()
                    .stream()
                    .map(CidadeDTO::toModel)
                    .collect(Collectors.toList());

            estado.setCidades(collect);
        }
        return estado;
    }
}
