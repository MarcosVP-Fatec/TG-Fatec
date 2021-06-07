package br.gov.sp.fatec.gedam.model.entity.comm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import br.gov.sp.fatec.gedam.tool.Data;

@MappedSuperclass
public abstract class GeneratorAudit {

    //@JsonView(View.AuditInc.class)
    @Column(insertable = true, updatable = false)   Long    _inc_usua;    
    //@JsonView(View.AuditInc.class)
    @Column(insertable = true, updatable = false)   Date    _inc_data;
    //@JsonView(View.AuditAlt.class)
    @Column(insertable = false, updatable = true)   Long    _alt_usua;    
    //@JsonView(View.AuditAlt.class)
    @Column(insertable = false, updatable = true)   Date    _alt_data;
    
    // CONSTRUTOR
    public GeneratorAudit(){

        //set_Inc_Usua( usuario_autenticado );
        set_Inc_Data( Data.today() );
        //set_Alt_Usua( usuario_autenticado  );
        set_Alt_Data( Data.today() );

    }

    // Getters and Setters
    public Long get_Inc_Usua()              { return _inc_usua;             }
    public void set_Inc_Usua(Long _inc_usua){ this._inc_usua = _inc_usua;   }
    public Date get_Inc_Data()              { return _inc_data;             }
    public void set_Inc_Data(Date _inc_data){ this._inc_data = _inc_data;   }
    public Long get_Alt_Usua()              { return _alt_usua;             }
    public void set_Alt_Usua(Long _alt_usua){ this._alt_usua = _alt_usua;   }
    public Date get_Alt_Data()              { return _alt_data;             }
    public void set_Alt_Data(Date _alt_data){ this._alt_data = _alt_data;   }

    //Atualização das alteraões (Generics)
    public static <T> void setAll( T  t ){
        //((GeneratorAudit) t).set_Inc_Usua( usuario_autenticado );
        ((GeneratorAudit) t).set_Inc_Data( Data.today() );
        GeneratorAudit.setAudit(t);
    }
    public static <T> void setAudit( T  t ){
        //( (GeneratorAudit) t).set_Alt_Usua( usuario_autenticado );
        ( (GeneratorAudit) t).set_Alt_Data( Data.today() );
    }
    
}