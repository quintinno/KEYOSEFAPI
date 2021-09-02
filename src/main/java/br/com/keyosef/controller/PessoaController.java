package br.com.keyosef.controller;

import br.com.keyosef.model.PessoaModel;
import br.com.keyosef.service.PessoaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/gerenciador-pessoa")
public class PessoaController implements Serializable {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll() {
        return ResponseEntity.ok().body(this.pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaModel> save(@RequestBody PessoaModel pessoaModel) {
        return ResponseEntity.ok().body(this.pessoaService.save(pessoaModel));
    }

}
