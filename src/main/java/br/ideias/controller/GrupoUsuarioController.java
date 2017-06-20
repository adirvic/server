package br.ideias.controller;

import br.ideias.dto.GrupoUsuarioDTO;
import br.ideias.model.GrupoUsuario;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by adirvic on 19/06/17.
 */
@RestController
@RequestMapping(path = "grupo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GrupoUsuarioController {

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity save (@RequestBody GrupoUsuarioDTO grupoUsuarioDTO){
return null;

    }

}
