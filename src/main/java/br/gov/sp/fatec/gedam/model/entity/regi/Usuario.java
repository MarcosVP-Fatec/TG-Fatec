package br.gov.sp.fatec.gedam.model.entity.regi;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorId;
import br.gov.sp.fatec.gedam.tool.Validador;

@Entity
@Table(name = "sec_usuario")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Usuario extends GeneratorId{

    @Column(name="nome"     ,length = 30 , unique = true , nullable = false)  private String nome;
    @Column(name="email"    ,length = 500, unique = false, nullable = false)  private String email;
    @Column(name="validhash",length = 100, unique = false, nullable = false)  private String validHash;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sec_aut_usuario",
               joinColumns = { @JoinColumn(name="idusu") },
        inverseJoinColumns = { @JoinColumn(name="idaut") }
    )
    private Set<Autorizacao> autorizacoes;
    
    public String getNome() {return this.nome; }
    public void setNome(String nome) {
        if (nome.length() > 30){
            throw new RuntimeException("Tamanho inválido para o campo NOME do USUÁRIO: " + nome.length());
        }
        this.nome = nome.toUpperCase();
    }
    public String getEmail(){return this.email;}
    public void setEmail(String email) {
        if (email.length() > 500){
            throw new RuntimeException("Tamanho inválido para o campo EMAIL do USUÁRIO: " + email.length());
        }
        if (!Validador.isEmail(email)){
            throw new RuntimeException("EMAIL inválido: " + email);
        }
        this.email = email;
    }
    
    public String getValidHash(){return this.validHash;}
    public void setValidHash(String validHash) {
        if (validHash.length() > 100){
            throw new RuntimeException("Tamanho inválido para o campo VALIDHASH do USUÁRIO: " + validHash.length());
        }
        this.validHash = validHash;
    }
    public Set<Autorizacao> getAutorizacoes() {
        return this.autorizacoes;
    }
    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

}