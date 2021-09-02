package br.com.keyosef.service;

import br.com.keyosef.model.PapelPessoaModel;
import br.com.keyosef.model.PessoaModel;
import br.com.keyosef.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class PessoaService implements Serializable {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PapelPessoaService papelPessoaService;

    public List<PessoaModel> findAll() {
        return this.pessoaRepository.findAll();
    }

    public PessoaModel save(PessoaModel pessoaModel) {
        this.carregarPapelPessoa(pessoaModel);
        pessoaModel.setAtivo(true);
        return this.pessoaRepository.save(pessoaModel);
    }

    @Transactional
    private void carregarPapelPessoa(PessoaModel pessoaModel) {
        PapelPessoaModel papelPessoaModel = this.papelPessoaService.findOne(pessoaModel.getPapelPessoaID());
        pessoaModel.getPapelPessoaModelList().add(papelPessoaModel);
    }

}
