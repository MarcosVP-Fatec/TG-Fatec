package br.gov.sp.fatec.gedam.model.entity.stat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.gedam.service.stat.MesRepository;

@SpringBootTest
@Transactional
@Rollback
public class MesTests {

    @Autowired
    private MesRepository   mesRepo;

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into est_mes (id, descr) values (?,?)"
            , "99"
            , "Teste"
        );

    }

    @Test
    void alterar(){
        Mes mes = mesRepo.findById("99").get();
        mes.setDescr("Alterado");
        mesRepo.saveAndFlush(mes);
        assertEquals("Alterado", mes.getDescr());
    }
    
    @Test
    void excluir(){
        assertTrue(mesRepo.existsById("99"));
        mesRepo.delete(mesRepo.findById("99").get());
        assertFalse(mesRepo.existsById("99"));
    }

    @Test
    void pesquisar(){
        List<Mes> meses = mesRepo.buscarTodosOsMeses();
        assertEquals(13, meses.size());
    }

    @Test
    void incluir(){
        Mes mes = new Mes();
        mes.setId("20");
        mes.setDescr("TesteInc");
        mesRepo.saveAndFlush(mes);
        List<Mes> meses = mesRepo.buscarTodosOsMeses();
        assertEquals(14, meses.size());
        assertTrue(mesRepo.existsById("20"));
    }

}

