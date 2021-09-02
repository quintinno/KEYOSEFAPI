package br.com.keyosef.controller;

import br.com.keyosef.model.PapelPessoaModel;
import br.com.keyosef.service.PapelPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/gerenciador-papel-pessoa")
public class PapelPessoaController implements Serializable {

    @Autowired
    private PapelPessoaService papelPessoaService;

    @GetMapping
    public ResponseEntity<List<PapelPessoaModel>> findAll() {
        return ResponseEntity.ok().body(this.papelPessoaService.findAll());
    }

}
