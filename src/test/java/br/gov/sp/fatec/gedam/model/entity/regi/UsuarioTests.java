package br.gov.sp.fatec.gedam.model.entity.regi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.gedam.service.regi.AutorizacaoRepository;
import br.gov.sp.fatec.gedam.service.regi.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioTests {

    @Autowired
    private AutorizacaoRepository   autoRepo;

    @Autowired
    private UsuarioRepository       usuRepo;

    final static String NOME_1  =   "#NOME_USUARIO_1";
    final static String NOME_2  =   "#NOME_USUARIO_2";
    final static String EMAIL_1 =   "#usuario1@gedam.br";
    final static String EMAIL_2 =   "#usuario2@gedam.br";
    final static String VALID_1 =   "#VALID_USUARIO_1";

    @BeforeEach
    void iniciar(@Autowired JdbcTemplate jdbc){

        jdbc.update(
            "insert into sec_usuario (nome, email, validhash) values (?,?,?)"
            , NOME_1
            , EMAIL_1
            , VALID_1
        );

    }

    @Test
    void alterar(){

        Usuario usuario = usuRepo.findByNome(NOME_1).get();
        assertTrue(usuRepo.existsByNome(NOME_1));
        usuario.setNome(NOME_2);
        usuario.setEmail(EMAIL_2);
        usuRepo.saveAndFlush(usuario);
        assertFalse(usuRepo.existsByNome(NOME_1));
    }

    @Test
    void excluir(){

        assertTrue(usuRepo.existsByNome(NOME_1));
        usuRepo.delete(usuRepo.findByNome(NOME_1).get());
        usuRepo.flush();
        assertFalse(usuRepo.existsByNome(NOME_1));
    }

    @Test
    void incluir(){

        assertFalse(usuRepo.existsByNome(NOME_2));

        Usuario usuario = new Usuario();
        usuario.setNome(NOME_2);
        usuario.setEmail(EMAIL_2);
        usuario.setValidHash("##");
        usuario.setAutorizacoes(buscaAutorizacoes());
        usuRepo.saveAndFlush(usuario);

        assertTrue(usuRepo.existsByNome(NOME_2));

    }

    private Set<Autorizacao> buscaAutorizacoes(){
        Iterator<Autorizacao> iterator = autoRepo.findAll().iterator();
        Set<Autorizacao> autorizacoes = new HashSet<>();
        autorizacoes.add(iterator.next());
        autorizacoes.add(iterator.next());
        return autorizacoes;
    }
    
}
