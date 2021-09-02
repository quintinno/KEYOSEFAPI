package br.com.keyosef.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_PAPEL_PESSOA")
public class PapelPessoaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "DESCRICAO", unique = true, nullable = false)
    private String descricao;

    @Column(name = "SIGLA", unique = true, nullable = false)
    private String sigla;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_PESSOA_PAPEL", joinColumns =
        @JoinColumn(name = "ID_PAPEL", referencedColumnName = "codigo", nullable = false), inverseJoinColumns =
        @JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "ID_PAPEL", "ID_PESSOA" })})
    private List<PessoaModel> pessoaModelList = new ArrayList<>();

    public PapelPessoaModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<PessoaModel> getPessoaModelList() {
        return pessoaModelList;
    }

    public void setPessoaModelList(List<PessoaModel> pessoaModelList) {
        this.pessoaModelList = pessoaModelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PapelPessoaModel that = (PapelPessoaModel) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}
