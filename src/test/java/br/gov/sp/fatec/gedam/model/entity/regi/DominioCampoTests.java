package br.gov.sp.fatec.gedam.model.entity.regi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.gedam.service.regi.DominioCampoRepository;

@SpringBootTest
@Transactional
@Rollback
public class DominioCampoTests {

    @Autowired
    private DominioCampoRepository  domRepo;

    final static String IDDOM_1     =   "#TESTE_DOM_CAMPO_1";
    final static String IDDOM_2     =   "#TESTE_DOM_CAMPO_2";
    final static String PADRAO_1    =   "#TESTE_DOM_PADRAO_1";
    final static String PADRAO_2    =   "#TESTE_DOM_PADRAO_2";
    final static String TIPOCOL_1   =   "N";

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into mer_dominio_campo (iddomcampo, padrao, idtipocol, tamanho, decimais) values (?,?,?,?,?)"
            , IDDOM_1
            , PADRAO_1
            , TIPOCOL_1
            , 12
            , 2
        );

    }

    @Test
    void alterar(){

        DominioCampo dominio = domRepo.findById(IDDOM_1).get();
        assertTrue(domRepo.existsById(IDDOM_1));
        dominio.setPadrao(PADRAO_2);
        domRepo.saveAndFlush(dominio);
        assertEquals(PADRAO_2,dominio.getPadrao());

    }

    @Test
    void excluir(){

        assertTrue(domRepo.existsById(IDDOM_1));
        domRepo.delete(domRepo.findById(IDDOM_1).get());
        domRepo.flush();
        assertFalse(domRepo.existsById(IDDOM_1));

    }

    @Test
    void incluir(){

        assertFalse(domRepo.existsById(IDDOM_2));
        DominioCampo dominio = new DominioCampo();
        dominio.setId(IDDOM_2);
        dominio.setIdTipoColuna("C");
        dominio.setPadrao(PADRAO_2);
        dominio.setTamanho(80);
        domRepo.saveAndFlush(dominio);
        assertTrue(domRepo.existsById(IDDOM_2));

    }
    
}
