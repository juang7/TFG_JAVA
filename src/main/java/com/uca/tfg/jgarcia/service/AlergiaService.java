package com.uca.tfg.jgarcia.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.uca.tfg.jgarcia.dto.AlergiaDTO;
import com.uca.tfg.jgarcia.model.Alergia;

public interface AlergiaService {

	/**
	 * Realiza la busqueda de todos los alergia existentes
	 * 
	 * @return listado de alergia
	 */
	List<AlergiaDTO> findAll();

	/**
	 * Transforma un alergia en un alergiaDTO
	 * 
	 * @param alergia
	 * @return
	 */
	AlergiaDTO transform(Alergia alergia);

	/**
	 * Transforma un alergiaDTO en un alergia
	 * 
	 * @param alergia
	 * @return
	 */
	Alergia transform(AlergiaDTO alergia);

	/**
	 * Transforma una lista de alergia en una lista de alergiaDTO
	 * 
	 * @param List
	 *            <Alergia>
	 * @return List<AlergiaDTO>
	 */
	List<AlergiaDTO> transform(List<Alergia> alergia);

	/**
	 * Crea un alergiaDTO
	 * 
	 * @param AlergiaDTO
	 * @return AlergiaDTO
	 * @throws InvalidDataException
	 */
	AlergiaDTO create(AlergiaDTO alergia);

	/**
	 * Devuelve, si existe, un alergia cuyo id corresponda con el introducido
	 * 
	 * @param id
	 * @return AlergiaDTO
	 * @throws AlergiaNotFoundException
	 */
	Alergia getById(Integer id);

	/**
	 * Devuelve, si existe, un alergia cuyo id corresponda con el introducido
	 * 
	 * @param id
	 * @return AlergiaDTO
	 * @throws AlergiaNotFoundException
	 */
	AlergiaDTO getByIdDTO(Integer id);

	/**
	 * Devuelve, si existe, los alergia cuyo nombre, isbn o autor correspondan
	 * con los introducidos
	 * 
	 * @param name
	 * @param isbn
	 * @param author
	 * @return List<AlergiaDTO>
	 * @throws AlergiaNotFoundException
	 */
	List<AlergiaDTO> getByParams(String id, String descripcion, Pageable pageable);

	/**
	 * Permite la modificacion de un alergia concreto
	 * 
	 * @param alergia
	 * @throws InvalidDataException
	 */
	void update(AlergiaDTO alergia);

	/**
	 * Elimina un alergia cuyo id corresponda con el introducido
	 * 
	 * @param id
	 * @throws AlergiaNotFoundException
	 */
	void delete(Integer id);

}