package br.com.keyosef.controller;

import br.com.keyosef.model.CategoriaPessoaModel;
import br.com.keyosef.service.CategoriaPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/gerenciador-categoria-pessoa")
public class CategoriaPessoaController implements Serializable {

    @Autowired
    private CategoriaPessoaService categoriaPessoaService;

    @GetMapping
    public ResponseEntity<List<CategoriaPessoaModel>> findAll() {
        return ResponseEntity.ok().body(this.categoriaPessoaService.findAll());
    }

}
