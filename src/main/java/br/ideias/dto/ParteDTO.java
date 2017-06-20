package br.ideias.dto;

import br.ideias.model.Parte;
import br.ideias.model.TipoParte;
import lombok.Data;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class ParteDTO implements BaseDTO<Parte>{

    private Long id;
    private TipoParteDTO tipoParte;
    private String descricao;
    private int rating;

    public ParteDTO() {

    }

    public ParteDTO(Parte parte) {
        troca(parte::getId,this::setId);
        troca(parte::getRating,this::setRating);
        troca(parte::getTipoParte,this::setTipoParte,TipoParteDTO::new);
        troca(parte::getDescricao,this::setDescricao);
    }

    @Override
    public Parte toModel() {
        Parte parte = new Parte();

        troca(this::getId,parte::setId);
        troca(this::getRating,parte::setRating);
        troca(this::getTipoParte,parte::setTipoParte,TipoParteDTO::toModel);
        troca(this::getDescricao,parte::setDescricao);

        return parte;
    }
}
