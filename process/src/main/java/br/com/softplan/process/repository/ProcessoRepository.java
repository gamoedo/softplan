package br.com.softplan.process.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.softplan.process.model.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, String>{

    @Query("SELECT p FROM tb_processo p WHERE p.processoJaComParecer = ?1")
    public List<Processo> findByIsParecerFalse(Integer semParecer);
    
}
