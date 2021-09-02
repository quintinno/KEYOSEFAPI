package br.com.keyosef.service;

import br.com.keyosef.model.PessoaModel;
import br.com.keyosef.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PessoaService implements Serializable {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll() {
        return this.pessoaRepository.findAll();
    }

    public PessoaModel save(PessoaModel pessoaModel) {
        return this.pessoaRepository.save(pessoaModel);
    }

}
