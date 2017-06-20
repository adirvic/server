package br.ideias.dto;

import br.ideias.model.Cidade;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class CidadeDTO implements BaseDTO<Cidade> {


    private Long id;
    private String nome;

    public CidadeDTO(Cidade cidade) {
        troca(cidade::getId,this::setId);
        troca(cidade::getNome,this::setNome);
    }


    @Override
    public Cidade toModel() {
        Cidade cidade = new Cidade();

        troca(this::getId,cidade::setId);
        troca(this::getNome,cidade::setNome);

        return cidade;
    }
}
