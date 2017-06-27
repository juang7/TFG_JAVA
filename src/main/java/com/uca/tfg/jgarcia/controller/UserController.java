package com.uca.tfg.jgarcia.controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uca.tfg.jgarcia.dto.*;
import com.uca.tfg.jgarcia.controller.*;
import com.uca.tfg.jgarcia.model.Alergia;
import com.uca.tfg.jgarcia.model.User;
import com.uca.tfg.jgarcia.service.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AlergiaService alergiaService;
	
	@RequestMapping(method = { RequestMethod.POST })
	public UserDTO create(@RequestBody UserDTO user) {
		return userService.create(user);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public UserDTO get(@PathVariable("id") Integer id) {
		return userService.getByIdDTO(id);
	}

	@RequestMapping(method = { RequestMethod.GET })
	public List<UserDTO> getUsers(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "fecha_nacimiento", required = false) Date fecha_nacimiento,
			@RequestParam(value = "apellido", required = false) String apellido,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "alergias", required = false) Set<Alergia> alergia,			
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		return userService.findAll();
		/*
		return userService.getByParams(id,nombre,apellido,
				email,fecha_nacimiento, new PageRequest(page, size));
		*/
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody UserDTO user){
		userService.update(user);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id){
		userService.delete(id);
	}
	@RequestMapping(value = "/alergia/{id}", method = { RequestMethod.GET })
	public List<Alergia> getAlergiasUser(@PathVariable("id") Integer id) {
		return userService.getAlergiaById(id);
	}
	
	@RequestMapping(value = "addAlergia/{user_id}/{alergia_id}", method = { RequestMethod.PUT })
	public void addAlergia(@PathVariable("user_id") Integer user_id, @PathVariable("alergia_id") Integer alergia_id){
		UserDTO user = userService.getByIdDTO(user_id);
		user.getAlergias().add(alergiaService.getByIdDTO(alergia_id));
		userService.update(user);
		
	}
	@RequestMapping(value = "deleteAlergia/{user_id}/{alergia_id}", method = { RequestMethod.PUT })
	public void deleteAlergia(@PathVariable("user_id") Integer user_id, @PathVariable("alergia_id") Integer alergia_id){
		UserDTO user = userService.getByIdDTO(user_id);
		List <AlergiaDTO> alergias = user.getAlergias();
		for(int i = 0; i<alergias.size();i++ ){
			if(alergias.get(i).get_id()==alergia_id){
				alergias.remove(i);
			}
		}
		
		userService.update(user);
		
	}
	
}
