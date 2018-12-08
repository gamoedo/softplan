package br.com.softplan.process.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softplan.process.model.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, String>{

}
