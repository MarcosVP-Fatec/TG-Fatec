package br.gov.sp.fatec.gedam.model.entity.stat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorAudit;

/**
 * @author Marcos Vinicio Pereira
 * @category Entidades - Estáticas
 * @version 1.0
 */
@Entity
@Table(name = "mer_coluna_tipo")
public class ColunaTipo extends GeneratorAudit{

    @Id
    @Column(name = "id"       , length = 1,  unique = true , nullable = false, updatable = false )
    private String id;

    @Column(name = "descr"    , length = 20, unique = true, nullable = false, updatable = true )
    private String descr;

    @Column(name = "istamanho", updatable = true )
    private boolean isTamanho;

    @Column(name = "isdecimal", updatable = true )
    private boolean isDecimal;

    public String getId()               {return id;         }
    public void setId(String id)        {this.id = id;      }
    public String getDescr()            {return descr;      }
    public void setDescr(String descr)  {this.descr = descr;}
    public boolean isTamanho()          {return isTamanho;  }
    public boolean isDecimal()          {return isDecimal;  }
    public void setTamanho(boolean isTamanho) {
        if (!isTamanho && isDecimal()){
            setDecimal(false);
        }
        this.isTamanho = isTamanho;
    }
    public void setDecimal(boolean isDecimal) {
        if (isDecimal && !isTamanho()){
            throw new RuntimeException("Parâmetro de tipo de coluna que aceita decimal sem obrigar informar o tamanho: tipo \"" + id + "\"");
        }
        this.isDecimal = isDecimal;
    }

    
}
