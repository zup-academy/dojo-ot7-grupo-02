package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.model.dto.CompanhiaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    @PostMapping
    public void cadastra(@RequestBody CompanhiaDto companhiaDto) {

    }
}