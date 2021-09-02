package br.com.keyosef.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column(name = "IS_INSTITUICAO_FINANCEIRA", nullable = false)
    private Boolean isInstituicaoFinanceira;

    @Column(name = "IS_ATIVO", nullable = false)
    private Boolean isAtivo;

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
