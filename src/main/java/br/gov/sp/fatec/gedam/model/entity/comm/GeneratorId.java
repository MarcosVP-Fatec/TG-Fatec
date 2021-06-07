package br.gov.sp.fatec.gedam.model.entity.comm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Setter;

import lombok.Getter;

@MappedSuperclass
@Getter
@Setter
public class GeneratorId extends GeneratorAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //CONSTRUTOR
    public GeneratorId(){ super(); }

}