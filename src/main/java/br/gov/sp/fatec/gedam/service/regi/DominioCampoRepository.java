package br.gov.sp.fatec.gedam.service.regi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.regi.DominioCampo;

@Repository
public interface DominioCampoRepository extends JpaRepository<DominioCampo, String>{

    public Optional<DominioCampo> findById(String id);

    public boolean existsById(String id);

    public List<DominioCampo> findAll();

}
