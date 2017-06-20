package br.ideias.controller;

import br.ideias.dto.CidadeDTO;
import br.ideias.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adirvic on 19/06/17.
 */
@RestController
@RequestMapping(path = "cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id){

        CidadeDTO cidadeDTO = cidadeService.findOne(id);
        return new ResponseEntity(cidadeDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "list",method = RequestMethod.GET)
    public ResponseEntity list(){
        List<CidadeDTO> all = cidadeService.findAll();
        return new ResponseEntity(all,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity save(@RequestBody CidadeDTO cidadeDTO){
        CidadeDTO cidade = cidadeService.save(cidadeDTO);
        return new ResponseEntity(cidade,HttpStatus.OK);
    }

}
