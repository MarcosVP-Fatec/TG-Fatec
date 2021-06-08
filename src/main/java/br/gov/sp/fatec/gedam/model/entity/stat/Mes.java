package br.gov.sp.fatec.gedam.model.entity.stat;

import javax.persistence.AttributeOverride;
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
@Table(name = "est_mes")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Mes extends GeneratorAudit {

    @Id
    @Column(name = "id"   , length = 2, unique = false, nullable = false, updatable = false)
    private String id;

    @Column(name = "descr", length = 9, unique = true , nullable = false, updatable = true )
    private String descr;

    //GETTERS / SETTERS
    public String getId()               { return this.id;       }
    public void setId(String id)        { this.id = id;         }
    public String getDescr()            { return this.descr;    }
    public void setDescr(String descr)  { this.descr = descr;   }

}
