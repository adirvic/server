package br.ideias.controller;

import br.ideias.dto.EstadoDTO;
import br.ideias.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@RestController
@RequestMapping(path = "estado",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id){

        EstadoDTO estadoDTO = estadoService.findOne(id);
        return new ResponseEntity(estadoDTO,HttpStatus.OK);
    }

    @RequestMapping(path = "list",method = RequestMethod.GET)
    public ResponseEntity list(){
        List<EstadoDTO> all = estadoService.findAll();
        return new ResponseEntity(all,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity save(@RequestBody EstadoDTO estadoDto){
        EstadoDTO estado = estadoService.save(estadoDto);
        return new ResponseEntity(estado,HttpStatus.OK);
    }

}
