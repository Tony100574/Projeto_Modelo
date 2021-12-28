package com.example.projetoAntonio.connections.controllers;

import com.example.projetoAntonio.port.datatransfer.ContaList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @GetMapping
    public ResponseEntity<String> getContas(){
        try {
            return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(ContaList.getContas()), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Erro!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContaById(@PathVariable(value = "id") long id){
        try {
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(ContaList.getUserById(id)), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Erro!", HttpStatus.BAD_REQUEST);
    }

}
