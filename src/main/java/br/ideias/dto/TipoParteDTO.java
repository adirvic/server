package br.ideias.dto;

import br.ideias.model.TipoParte;
import lombok.Data;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class TipoParteDTO implements BaseDTO<TipoParte>{
    private Long id;
    private String descricao;

    public TipoParteDTO() {
    }
    public TipoParteDTO(TipoParte tipoParte) {
        troca(tipoParte::getId,this::setId);
        troca(tipoParte::getDescricao,this::setDescricao);
    }

    @Override
    public TipoParte toModel() {
        TipoParte tipoParte= new TipoParte();

        troca(this::getId,tipoParte::setId);
        troca(this::getDescricao,tipoParte::setDescricao);

        return tipoParte;
    }
}
