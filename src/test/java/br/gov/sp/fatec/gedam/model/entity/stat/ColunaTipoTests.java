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

import br.gov.sp.fatec.gedam.service.stat.ColunaTipoRepository;

@SpringBootTest
@Transactional
@Rollback
public class ColunaTipoTests {

    @Autowired
    private ColunaTipoRepository    tipoRepo;
    
    final String    ID_1        =   "@";
    final String    ID_2        =   "!";
    final String    DESCR_1     =   "#TESTE_TIPO_COLUNA_1";
    final String    DESCR_2     =   "#TESTE_TIPO_COLUNA_2";

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into mer_coluna_tipo (id, descr, istamanho, isdecimal) values (?,?,?,?)"
            , String.valueOf(ID_1)
            , DESCR_1
            , 1
            , 1
        );

    }
    
    @Test
    void alterar(){
        ColunaTipo tipo = tipoRepo.findById(ID_1).get();
        tipo.setDescr(DESCR_2);
        tipo.setTamanho(true);
        tipo.setDecimal(true);
        tipoRepo.saveAndFlush(tipo);
        assertEquals(DESCR_2, tipo.getDescr());
    }

    @Test
    void excluir(){
        assertTrue(tipoRepo.existsById(ID_1));
        tipoRepo.delete(tipoRepo.findById(ID_1).get());
        assertFalse(tipoRepo.existsById(ID_1));
    }

    @Test
    void pesquisar(){
        List<ColunaTipo> tipos = tipoRepo.buscarTodosOsTiposDeColunas();
        assertFalse( tipos.size() == 0);
    }

    @Test
    void incluir(){
        ColunaTipo tipo = new ColunaTipo();
        tipo.setId(ID_2);
        tipo.setDescr(DESCR_2);
        tipo.setTamanho(false);
        tipo.setDecimal(false);
        tipoRepo.saveAndFlush(tipo);
        assertTrue(tipoRepo.existsByDescrContainingIgnoreCase(DESCR_2));
    }
}
