package br.com.zup.edu.nossositedeviagens.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aeroporto")
public class AeroportController {
    @PostMapping
    public ResponseEntity cadastrar(){

        return null;
    }

}
