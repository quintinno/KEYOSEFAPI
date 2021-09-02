package br.com.keyosef.service;

import br.com.keyosef.model.CategoriaPessoaModel;
import br.com.keyosef.repository.CategoriaPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaPessoaService implements Serializable {

    @Autowired
    private CategoriaPessoaRepository categoriaPessoaRepository;

    public List<CategoriaPessoaModel> findAll() {
        return this.categoriaPessoaRepository.findAll();
    }

    public CategoriaPessoaModel findOne(Long categoriaPessoaID) {
        Optional<CategoriaPessoaModel> categoriaPessoaModelOptional = this.categoriaPessoaRepository.findById(categoriaPessoaID);
        return categoriaPessoaModelOptional.get();
    }

}
