package br.com.keyosef.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "NOME_COMPLETO", nullable = false)
    private String nomeCompleto;

    @Column(name = "LOCALIZACAO", nullable = false)
    private String localizacao;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "IMAGEM", nullable = true)
    private byte[] imagem;

    @JsonProperty("isInstituicaoFinanceira")
    @Column(name = "IS_INSTITUICAO_FINANCEIRA", nullable = false)
    private Boolean isInstituicaoFinanceira;

    @JsonProperty("isAtivo")
    @Column(name = "IS_ATIVO", nullable = false)
    private Boolean isAtivo;

    @JsonProperty("categoriaPessoa")
    @OneToOne
    @JoinColumn(name = "ID_CATEGORIA_PESSOA", referencedColumnName = "codigo", nullable = false)
    private CategoriaPessoaModel categoriaPessoaModel;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_PESSOA_PAPEL", joinColumns =
        @JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false), inverseJoinColumns =
        @JoinColumn(name = "ID_PAPEL", referencedColumnName = "codigo", nullable = false), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "ID_PESSOA", "ID_PAPEL" })})
    List<PapelPessoaModel> papelPessoaModelList = new ArrayList<>();

    @JsonProperty("papelPessoaID")
    @Transient
    private Long papelPessoaID;

    public PessoaModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Boolean getInstituicaoFinanceira() {
        return isInstituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(Boolean instituicaoFinanceira) {
        isInstituicaoFinanceira = instituicaoFinanceira;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public CategoriaPessoaModel getCategoriaPessoaModel() {
        return categoriaPessoaModel;
    }

    public void setCategoriaPessoaModel(CategoriaPessoaModel categoriaPessoaModel) {
        this.categoriaPessoaModel = categoriaPessoaModel;
    }

    public List<PapelPessoaModel> getPapelPessoaModelList() {
        return papelPessoaModelList;
    }

    public void setPapelPessoaModelList(List<PapelPessoaModel> papelPessoaModelList) {
        this.papelPessoaModelList = papelPessoaModelList;
    }

    public Long getPapelPessoaID() {
        return papelPessoaID;
    }

    public void setPapelPessoaID(Long papelPessoaID) {
        this.papelPessoaID = papelPessoaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaModel that = (PessoaModel) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}
