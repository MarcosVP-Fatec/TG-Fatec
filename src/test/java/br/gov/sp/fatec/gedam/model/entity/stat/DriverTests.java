package br.gov.sp.fatec.gedam.model.entity.stat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.gedam.service.stat.DriverRepository;

@SpringBootTest
@Transactional
@Rollback
public class DriverTests {

    final static String NOME_1      =   "#NOME_DRIVER_1";
    final static String NOME_2      =   "#NOME_DRIVER_2";
    final static String VERSAO_1    =   "#VERSAO_DRIVER_1";
    final static String VERSAO_2    =   "#VERSAO_DRIVER_2";
    final static int    ANOMESVS_1  =   999999;
    final static int    ANOMESVS_2  =   1;

    @Autowired
    private DriverRepository    driverRepo;

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into mer_driver (nome, versao, anomesvs) values (?,?,?)"
            , NOME_1
            , VERSAO_1
            , ANOMESVS_1
        );

    }
    
    @Test
    void alterar(){
        Driver driver = driverRepo.findByNome(NOME_1).get();
        driver.setNome(NOME_2);
        driver.setVersao(VERSAO_2);
        driver.setAnoMesVs(ANOMESVS_2);
        driverRepo.saveAndFlush(driver);
        assertEquals(NOME_2, driver.getNome());
    }

    @Test
    void excluir(){
        assertTrue(driverRepo.existsByNome(NOME_1));
        driverRepo.delete(driverRepo.findByNome(NOME_1).get());
        assertFalse(driverRepo.existsByNome(NOME_1));
    }

    @Test
    void pesquisar(){
        List<Driver> drivers = driverRepo.buscarTodosOsDrivers();
        assertFalse( drivers.size() == 0);
    }

    @Test
    void incluir(){
        Driver driver = new Driver();
        driver.setNome(NOME_2);
        driver.setVersao(VERSAO_2);
        driver.setAnoMesVs(ANOMESVS_2);
        driverRepo.saveAndFlush(driver);
        assertTrue(driverRepo.existsByNome(NOME_2));
    }

}
