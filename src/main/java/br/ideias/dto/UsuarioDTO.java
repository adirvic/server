package br.ideias.dto;

import br.ideias.model.Formulario;
import br.ideias.model.Usuario;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adirvic on 19/06/17.
 */
@Data
public class UsuarioDTO implements BaseDTO<Usuario> {

    private Long id;
    private String email;
    private String nome;
    private List<FormularioDTO> formularios;

    public UsuarioDTO(Usuario usuario) {
        troca(usuario::getId,this::setId);
        troca(usuario::getNome,this::setNome);
        troca(usuario::getEmail,this::setEmail);
        if (usuario.getFormularios() != null){
            List<FormularioDTO> collect = usuario.getFormularios().stream().map(FormularioDTO::new).collect(Collectors.toList());
            this.setFormularios(collect);
        }

    }

    @Override
    public Usuario toModel() {
        Usuario usuario = new Usuario();

        troca(this::getId,usuario::setId);
        troca(this::getEmail,usuario::setEmail);
        troca(this::getNome,usuario::setNome);
        if (this.getFormularios() != null){
            List<Formulario> collect = getFormularios().stream().map(FormularioDTO::toModel).collect(Collectors.toList());
            usuario.setFormularios(collect);
        }
        return usuario;
    }
}
