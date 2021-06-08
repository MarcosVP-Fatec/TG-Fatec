package br.gov.sp.fatec.gedam.model.entity.regi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.gedam.service.regi.ModuloRepository;

@SpringBootTest
@Transactional
@Rollback
public class ModuloTests {

    @Autowired
    private ModuloRepository    moduloRepo;

    final static String NOME_1      =   "#NOME_MODULO_1";
    final static String NOME_2      =   "#NOME_MODULO_2";
    final static String PREFIXO_1   =   "#?1";
    final static String PREFIXO_2   =   "#?2";

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into mer_modulo (nome, prefixo ,prefixonochk) values (?,?,?)"
            , NOME_1
            , PREFIXO_1
            , "S"
        );

    }

    @Test
    void alterar(){

        Modulo modulo = moduloRepo.findByNome(NOME_1).get();
        assertTrue(moduloRepo.existsByNome(NOME_1));
        modulo.setNome(NOME_2);
        moduloRepo.saveAndFlush(modulo);
        assertFalse(moduloRepo.existsByNome(NOME_1));

    }

    @Test
    void excluir(){

        assertTrue(moduloRepo.existsByNome(NOME_1));
        moduloRepo.delete(moduloRepo.findByNome(NOME_1).get());
        moduloRepo.flush();
        assertFalse(moduloRepo.existsByNome(NOME_1));

    }


    @Test
    void incluir(){

        assertFalse(moduloRepo.existsByNome(NOME_2));
        Modulo modulo = new Modulo();
        modulo.setNome(NOME_2);
        modulo.setPrefixo(PREFIXO_2);
        modulo.setPrefixoNoChk("N");
        moduloRepo.saveAndFlush(modulo);
        assertTrue(moduloRepo.existsByNome(NOME_2));

    }

}
