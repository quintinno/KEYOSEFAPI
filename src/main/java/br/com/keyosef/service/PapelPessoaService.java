package br.com.keyosef.service;

import br.com.keyosef.model.PapelPessoaModel;
import br.com.keyosef.repository.PapelPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PapelPessoaService implements Serializable {

    @Autowired
    private PapelPessoaRepository papelPessoaRepository;

    public List<PapelPessoaModel> findAll() {
        return this.papelPessoaRepository.findAll();
    }

    public PapelPessoaModel findOne(Long papelPessoaID) {
        Optional<PapelPessoaModel> papelPessoaModelOptional = this.papelPessoaRepository.findById(papelPessoaID);
        return papelPessoaModelOptional.get();
    }

}
