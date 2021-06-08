package br.gov.sp.fatec.gedam.model.entity.regi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorAudit;

@Entity
@Table(name = "mer_dominio_campo")
public class DominioCampo extends GeneratorAudit{

    @Id
    @Column(name="iddomcampo"  ,length = 30 , unique = true , nullable = false)  private String id;
    @Column(name="padrao"      ,length = 63 , unique = false, nullable = true )  private String padrao;
    @Column(name="idtipocol"   ,length = 1  , unique = false, nullable = false)  private String idTipoColuna;
    @Column(name="tamanho"     ,length = 4  , unique = false, nullable = false)  private int    tamanho;
    @Column(name="decimais"    ,length = 1  , unique = false, nullable = false)  private int    decimais;
    
    public String getId()                               {return id;                         }
    public void setId(String id)                        {this.id = id;                      }
    public String getPadrao()                           {return padrao;                     }
    public void setPadrao(String padrao)                {this.padrao = padrao;              }
    public String getIdTipoColuna()                     {return idTipoColuna;               }
    public void setIdTipoColuna(String idTipoColuna)    {this.idTipoColuna = idTipoColuna;  }
    public int getTamanho()                             {return tamanho;                    }
    public void setTamanho(int tamanho)                 {this.tamanho = tamanho;            }
    public int getDecimais()                            {return decimais;                   }
    public void setDecimais(int decimais)               {this.decimais = decimais;          }
    
}
