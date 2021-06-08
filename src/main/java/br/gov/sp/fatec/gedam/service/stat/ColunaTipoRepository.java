package br.gov.sp.fatec.gedam.service.stat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.stat.ColunaTipo;

@Repository
public interface ColunaTipoRepository extends JpaRepository<ColunaTipo, String>{

    public Optional<ColunaTipo> findById(String id);

    public boolean existsById(String id);

    public boolean existsByDescrContainingIgnoreCase(String descr);
    
    @Query("select t from ColunaTipo t order by upper(t.id)")
    public List<ColunaTipo> buscarTodosOsTiposDeColunas();
    
}
