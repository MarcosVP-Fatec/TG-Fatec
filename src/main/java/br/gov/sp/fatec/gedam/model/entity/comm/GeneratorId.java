package br.gov.sp.fatec.gedam.model.entity.comm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneratorId extends GeneratorAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //CONSTRUTOR
    public GeneratorId(){ super(); }

    //GETTERS / SETTERS
    public Long getId()         {return this.id;}
    public void setId(Long id)  {this.id = id;  }

}