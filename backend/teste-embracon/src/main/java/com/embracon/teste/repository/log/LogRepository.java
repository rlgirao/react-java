package com.embracon.teste.repository.log;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.embracon.teste.model.log.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
	
	@Query("SELECT l FROM Log l WHERE upper(l.uf) = upper(:uf) ORDER BY l.dtHrConsulta DESC LIMIT 20")
	List<Log> buscarPorUf(@Param("uf") String uf);
	
}
