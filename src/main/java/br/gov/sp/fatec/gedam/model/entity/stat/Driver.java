package br.gov.sp.fatec.gedam.model.entity.stat;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorId;

/**
 * @author Marcos Vinicio Pereira
 * @category Entidades - Estáticas
 * @version 1.0
 */
@Entity
@Table(name = "mer_driver")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Driver extends GeneratorId {

    @Column(name = "nome"    , length = 30, unique = true , nullable = false, updatable = true )
    private String nome;

    @Column(name = "versao"  , length = 30, unique = false, nullable = false, updatable = true )
    private String versao;

    @Column(name = "anomesvs", length = 30, unique = false, nullable = false, updatable = true )
    private int anoMesVs;

    //GETTERS | SETTERS
    public String getNome()              {return nome;              }
    public void setNome(String nome)     {this.nome = nome;         }
    public String getVersao()            {return versao;            }
    public void setVersao(String versao) {this.versao = versao;     }
    public int getAnoMesVs()             {return anoMesVs;          }
    public void setAnoMesVs(int anoMesVs){this.anoMesVs = anoMesVs; }
    
}
