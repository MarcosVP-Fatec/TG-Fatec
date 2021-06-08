package br.gov.sp.fatec.gedam.service.stat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.stat.Mes;

@Repository
public interface MesRepository extends JpaRepository<Mes, String>{
    
    public Optional<Mes> findById(String id);
    
    @Query("select m from Mes m order by m.id")
    public List<Mes> buscarTodosOsMeses();
    
}