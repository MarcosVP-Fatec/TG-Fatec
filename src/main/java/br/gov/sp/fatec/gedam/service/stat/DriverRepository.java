package br.gov.sp.fatec.gedam.service.stat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.gedam.model.entity.stat.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

    public Optional<Driver> findById(Long id);

    public Optional<Driver> findByNome(String nome);

    public boolean existsByNome(String nome);
    
    @Query("select d from Driver d order by upper(d.nome)")
    public List<Driver> buscarTodosOsDrivers();
    
}
