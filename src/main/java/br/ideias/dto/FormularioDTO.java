package br.ideias.dto;

import br.ideias.model.Formulario;
import br.ideias.model.Parte;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class FormularioDTO implements BaseDTO<Formulario> {

    private Long id;
    private UsuarioDTO usuario;
    private List<ParteDTO> partes;

    public FormularioDTO() {

    }
    public FormularioDTO(Formulario formulario) {

        troca(formulario::getId,this::setId);
        troca(formulario::getUsuario,this::setUsuario,UsuarioDTO::new);
        if (formulario.getPartes() != null){
            List<ParteDTO> collect = formulario.getPartes().stream().map(ParteDTO::new).collect(Collectors.toList());
            setPartes(collect);
        }

    }

    @Override
    public Formulario toModel() {
        Formulario formulario = new Formulario();

        troca(this::getId,formulario::setId);
        troca(this::getUsuario,formulario::setUsuario,UsuarioDTO::toModel);
        if (getPartes() != null){
            List<Parte> collect = getPartes().stream().map(ParteDTO::toModel).collect(Collectors.toList());
            formulario.setPartes(collect);
        }

        return formulario;
    }
}
