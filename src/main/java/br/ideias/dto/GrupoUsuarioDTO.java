package br.ideias.dto;

import br.ideias.model.Cidade;
import br.ideias.model.GrupoUsuario;
import br.ideias.model.Usuario;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class GrupoUsuarioDTO implements BaseDTO<GrupoUsuario>{

    private Long id;

    private CidadeDTO cidadeDTO;

    private List<UsuarioDTO> usuarios;

    public GrupoUsuarioDTO() {
    }
    public GrupoUsuarioDTO(GrupoUsuario grupoUsuario) {

        troca(grupoUsuario::getId,this::setId);
        troca(grupoUsuario::getCidade,this::setCidadeDTO, CidadeDTO::new);
        if (grupoUsuario.getUsuarios() != null){
            List<UsuarioDTO> collect = grupoUsuario.getUsuarios().stream().map(UsuarioDTO::new).collect(Collectors.toList());
            setUsuarios(collect);
        }

    }

    @Override
    public GrupoUsuario toModel() {
        GrupoUsuario grupoUsuario = new GrupoUsuario();

        troca(this::getId,grupoUsuario::setId);
        if (getCidadeDTO() != null){
            Cidade cidade = getCidadeDTO().toModel();
            grupoUsuario.setCidade(cidade);
        }
        if (getUsuarios() != null){
            List<Usuario> collect = getUsuarios().stream().map(UsuarioDTO::toModel).collect(Collectors.toList());
            grupoUsuario.setUsuarios(collect);

        }

        return grupoUsuario;
    }
}
