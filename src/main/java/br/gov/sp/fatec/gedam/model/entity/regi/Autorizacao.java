package br.gov.sp.fatec.gedam.model.entity.regi;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.gedam.controller.comm.View;
import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorId;

/**
 * @author Marcos Vinicio Pereira
 * @category Entidades
 * @version 1.0
 */

@Entity
@Table(name = "sec_autorizacao")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Autorizacao extends GeneratorId{

    @Column(name="chave"    ,length = 30 , unique = true , nullable = false)  private String chave;
    @Column(name="descr"    ,length = 100, unique = false, nullable = false)  private String descr;
    
    @JsonView( View.AutorizacaoResumo.class )
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autorizacoes")
    private Set<Usuario> usuarios;

    public String getChave() {
        return this.chave;  
    }
    public void setChave(String chave) {
        if (chave.length() > 30){
            throw new RuntimeException("Tamanho inválido para o campo CHAVE da AUTORIZAÇÃO: " + chave.length());
        }
        this.chave = chave.toUpperCase();
    }
    
    public String getDescr() {
        return this.descr;
    }
    public void setDescr(String descr) {
        if (chave.length() > 100){
            throw new RuntimeException("Tamanho inválido para o campo DESCR da AUTORIZAÇÃO: " + chave.length());
        }
        this.descr = descr;
    }

}
