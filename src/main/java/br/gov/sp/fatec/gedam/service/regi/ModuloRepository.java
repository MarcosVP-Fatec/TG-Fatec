package br.gov.sp.fatec.gedam.service.regi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.regi.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

    public Optional<Modulo> findById(Long id);

    public Optional<Modulo> findByNome(String nome);

    public boolean existsByNome(String nome);
   
}