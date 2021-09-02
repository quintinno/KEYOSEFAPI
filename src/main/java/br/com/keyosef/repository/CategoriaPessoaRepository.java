package br.com.keyosef.repository;

import br.com.keyosef.model.CategoriaPessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaPessoaRepository extends JpaRepository<CategoriaPessoaModel, Long> { }
