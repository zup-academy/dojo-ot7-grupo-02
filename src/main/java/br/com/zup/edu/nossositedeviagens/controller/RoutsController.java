package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.annotation.ProibeRotasOrigensEDestinosIguaisValidator;
import br.com.zup.edu.nossositedeviagens.model.Rout;
import br.com.zup.edu.nossositedeviagens.model.dto.RoutDto;
import br.com.zup.edu.nossositedeviagens.model.dto.RoutResponse;
import br.com.zup.edu.nossositedeviagens.repository.AeroportReposity;
import br.com.zup.edu.nossositedeviagens.repository.RoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/rotas")
public class RoutsController {

    @Autowired
    AeroportReposity aeroportoRepository;

    @Autowired
    RoutRepository routRepository;

    @InitBinder(value = "routDto")
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ProibeRotasOrigensEDestinosIguaisValidator());
    }

    @PostMapping
    @Transactional
    ResponseEntity<RoutResponse> criaRota(@RequestBody @Valid RoutDto routDto, UriComponentsBuilder uriComponentsBuilder){
        Rout novaRota = routDto.converter(aeroportoRepository);
        routRepository.save(novaRota);
        URI uri = uriComponentsBuilder.path("/rotas/{id}").buildAndExpand(novaRota.getId()).toUri();
        return ResponseEntity.created(uri).body(new RoutResponse(novaRota));
    }

}