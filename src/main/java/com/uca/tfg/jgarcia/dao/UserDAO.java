package com.uca.tfg.jgarcia.dao;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.tfg.jgarcia.dto.UserDTO;
import com.uca.tfg.jgarcia.model.*;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

	@Query(value = "SELECT u from User as u where (u.id =:id OR :id is null) AND"
			+ "(u.nombre like %:nombre%) AND " + "(u.apellido like %:apellido% OR :apellido is null) AND"
			+ "(u.email like %:email% OR :email is null) AND" + "(u.fecha_nacimiento like %:fecha_nacimiento% OR :fecha_nacimiento is null)")
	
	List<User> findParams(@Param(value = "id") int id, @Param(value = "nombre") String nombre,
			@Param(value = "apellido") String apellido, @Param(value = "email") String email, @Param(value = "fecha_nacimiento")Date fecha_nacimiento, Pageable pageable);

	
	@Query(value = "SELECT u from User as u where (u.id=:id) ")
	User getAlergiaUser(@Param(value = "id") int id);

	
}