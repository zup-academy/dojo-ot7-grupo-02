package br.com.zup.edu.nossositedeviagens.controller;


import br.com.zup.edu.nossositedeviagens.Repository.AeroportReposity;
import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.model.dto.AeroportDto;
import br.com.zup.edu.nossositedeviagens.model.dto.AeroportResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/aeroporto")
public class AeroportController {

    AeroportReposity aeroportReposity;
    PaisRepository paisRepository;

    public AeroportController(AeroportReposity aeroportReposity, PaisRepository paisRepository) {
        this.aeroportReposity = aeroportReposity;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<AeroportResponse> cadastra(@RequestBody @Valid AeroportDto aeroportDto, UriComponentsBuilder uriComponentsBuilder) {
        var aeroport = aeroportDto.converter(this.paisRepository);
        var createdAeroport = aeroportReposity.save(aeroport);
        URI uri = uriComponentsBuilder.path("/aeroporto/{id}").buildAndExpand(createdAeroport.getId()).toUri();
        return ResponseEntity.created(uri).body(new AeroportResponse(createdAeroport));
    }
}
