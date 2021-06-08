package br.gov.sp.fatec.gedam.service.regi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.regi.Autorizacao;
import br.gov.sp.fatec.gedam.model.entity.regi.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findById(String id);

    public Optional<Usuario> findByNome(String nome);

    public boolean existsByNome(String nome);
    
    @Query("select a from Usuario u inner join u.autorizacoes a")
    public List<Autorizacao> buscarAutorizacoes();
    
}
