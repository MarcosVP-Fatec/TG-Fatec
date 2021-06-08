package br.gov.sp.fatec.gedam.service.regi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.regi.Autorizacao;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{

    public Optional<Autorizacao> findById(Long id);

    public Optional<Autorizacao> findByChave(String chave);

    public boolean existsByChave(String chave);
}
