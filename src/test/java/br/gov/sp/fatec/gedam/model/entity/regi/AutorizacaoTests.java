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

import br.gov.sp.fatec.gedam.service.AutorizacaoRepository;

@SpringBootTest
@Transactional
@Rollback
public class AutorizacaoTests {

    @Autowired
    private AutorizacaoRepository   autoRepo;

    final static String CHAVE_1  =   "ROLE_#TESTE_1";
    final static String CHAVE_2  =   "ROLE_#TESTE_2";
    final static String DESCR_1  =   "#Teste Unitário";

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into sec_autorizacao (chave, descr) values (?,?)"
            , CHAVE_1
            , DESCR_1
        );

    }

    @Test
    void alterar(){
        Autorizacao autorizacao = autoRepo.findByChave(CHAVE_1).get();
        assertFalse(autoRepo.existsByChave(CHAVE_2));
        autorizacao.setChave(CHAVE_2);
        autoRepo.saveAndFlush(autorizacao);
        assertTrue(autoRepo.existsByChave(CHAVE_2));
    }

    @Test
    void excluir(){
        assertTrue(autoRepo.existsByChave(CHAVE_1));
        autoRepo.delete(autoRepo.findByChave(CHAVE_1).get());
        assertFalse(autoRepo.existsByChave(CHAVE_1));
    }
    
    @Test
    void incluir(){
        int qtd = autoRepo.findAll().size();
        Autorizacao autorizacao = new Autorizacao();
        autorizacao.setChave(CHAVE_2);
        autorizacao.setDescr(DESCR_1);
        autoRepo.saveAndFlush(autorizacao);
        assertEquals(qtd+1, autoRepo.findAll().size());
    }

    @Test
    void pesquisar(){
        Autorizacao autorizacao = autoRepo.findByChave(CHAVE_1).get();
        assertEquals(DESCR_1, autorizacao.getDescr());
    }
}

