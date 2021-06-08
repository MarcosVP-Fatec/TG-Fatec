package br.gov.sp.fatec.gedam.model.entity.regi;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.gov.sp.fatec.gedam.model.entity.comm.GeneratorId;

@Entity
@Table(name = "mer_modulo")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Modulo extends GeneratorId {

    @Column(name="nome"     ,length = 30 , unique = true , nullable = false)  private String nome;

    public String getNome()         {return nome;       }
    public void setNome(String nome){this.nome = nome;  }

}
