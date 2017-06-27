package com.uca.tfg.jgarcia.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.uca.tfg.jgarcia.dto.*;
import com.uca.tfg.jgarcia.model.*; 


public interface UserService {

	/**
	 * Realiza la busqueda de todos los user existentes
	 * 
	 * @return listado de user
	 */
	List<UserDTO> findAll();

	/**
	 * Transforma un user en un userDTO
	 * 
	 * @param user
	 * @return
	 */
	UserDTO transform(User user);

	/**
	 * Transforma un userDTO en un user
	 * 
	 * @param user
	 * @return
	 */
	User transform(UserDTO user);

	/**
	 * Transforma una lista de user en una lista de userDTO
	 * @param List<User>
	 * @return List<UserDTO>
	 */
	List<UserDTO> transform(List<User> user);
	
	/**
	 * Crea un userDTO
	 * @param UserDTO
	 * @return UserDTO
	 * @throws InvalidDataException 
	 */
	UserDTO create(UserDTO user);
	
	/**
	 * Devuelve, si existe, un user cuyo id corresponda con el introducido
	 * @param id
	 * @return UserDTO
	 * @throws UserNotFoundException 
	 */
	User getById(Integer id);

	/**
	 * Devuelve, si existe, un user cuyo id corresponda con el introducido
	 * @param id
	 * @return UserDTO
	 * @throws UserNotFoundException 
	 */
	UserDTO getByIdDTO(Integer id);
	
	/**
	 * Devuelve, si existe, las alergia del user cuyo id corresponda con el introducido
	 * @param id
	 * @return lista de alergia
	 * @throws UserNotFoundException 
	 */
	List<Alergia> getAlergiaById(Integer user_id);
	
	/**
	 * Devuelve, si existe, los user cuyo nombre, isbn o autor correspondan con los introducidos
	 * @param name
	 * @param isbn
	 * @param author
	 * @return List<UserDTO>
	 * @throws UserNotFoundException 
	 */
	List<UserDTO> getByParams(int id, String nombre, String apellido,
			String email, Date fecha_nacimiento,
			Pageable pageable);
	
	/**
	 * Permite la modificacion de un user concreto
	 * @param user
	 * @throws InvalidDataException 
	 */
	void update(UserDTO user);

	/**
	 * Elimina un user cuyo id corresponda con el introducido
	 * @param id
	 * @throws UserNotFoundException 
	 */
	void delete(Integer id);



}