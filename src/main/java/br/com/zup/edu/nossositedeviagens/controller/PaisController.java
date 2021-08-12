package br.com.zup.edu.nossositedeviagens.controller;


import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.model.dto.PaisDto;
import br.com.zup.edu.nossositedeviagens.model.dto.PaisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    ResponseEntity<PaisResponse> cadastrar (@RequestBody @Valid PaisDto pais, UriComponentsBuilder uriComponentsBuilder){
        Pais paisOriginal = pais.converter();
        paisRepository.save(paisOriginal);
        URI uri = uriComponentsBuilder.path("/pais/{id}").buildAndExpand(paisOriginal.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisResponse(paisOriginal));
    }

}
