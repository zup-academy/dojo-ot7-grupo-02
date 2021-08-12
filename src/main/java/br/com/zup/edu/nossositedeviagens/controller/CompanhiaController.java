package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.Repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.model.dto.CompanhiaDto;
import br.com.zup.edu.nossositedeviagens.model.dto.CompanhiaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository companhiaRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<CompanhiaResponse> cadastra(@RequestBody @Valid CompanhiaDto companhiaDto, UriComponentsBuilder uriComponentsBuilder) {

        var companhia = companhiaDto.converter(this.paisRepository);
        var createdComp = companhiaRepository.save(companhia);
        URI uri = uriComponentsBuilder.path("/companhia/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompanhiaResponse(createdComp));

    }
}
