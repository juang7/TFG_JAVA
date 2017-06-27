package com.uca.tfg.jgarcia.dao;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.tfg.jgarcia.model.*;

@Repository
public interface AlergiaDAO extends CrudRepository<Alergia, Integer> {

	@Query(value = "SELECT a from Alergia as a where (a.id like %:id% OR :id is null) AND"
			+ "(a.descripcion like %:descripcion%)")
	
	List<Alergia> findParams(@Param(value = "id") String id, @Param(value = "descripcion") String descripcion, Pageable pageable);

}