package br.com.keyosef.controller;

import br.com.keyosef.model.CategoriaPessoaModel;
import br.com.keyosef.service.CategoriaPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/gerenciador-categoria-pessoa")
@CrossOrigin("*")
public class CategoriaPessoaController implements Serializable {

    @Autowired
    private CategoriaPessoaService categoriaPessoaService;

    @GetMapping
    public ResponseEntity<List<CategoriaPessoaModel>> findAll() {
        return ResponseEntity.ok().body(this.categoriaPessoaService.findAll());
    }

    @GetMapping("/{categoriaPessoaID}")
    public ResponseEntity<CategoriaPessoaModel> findOne(@PathVariable Long categoriaPessoaID) {
        return ResponseEntity.ok().body(this.categoriaPessoaService.findOne(categoriaPessoaID));
    }

}
