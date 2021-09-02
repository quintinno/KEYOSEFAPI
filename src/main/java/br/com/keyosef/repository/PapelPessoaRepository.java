package br.com.keyosef.repository;

import br.com.keyosef.model.PapelPessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelPessoaRepository extends JpaRepository<PapelPessoaModel, Long> { }
