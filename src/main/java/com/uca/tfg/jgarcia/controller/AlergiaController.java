package com.uca.tfg.jgarcia.controller;

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
import com.uca.tfg.jgarcia.service.*;

@RestController
@RequestMapping(value = "/alergia")
public class AlergiaController {

	@Autowired
	private AlergiaService alergiaService;

	@RequestMapping(method = { RequestMethod.POST })
	public AlergiaDTO create(@RequestBody AlergiaDTO alergia) {
		return alergiaService.create(alergia);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public AlergiaDTO get(@PathVariable("id") Integer id) {
		return alergiaService.getByIdDTO(id);
	}

	@RequestMapping(method = { RequestMethod.GET })
	public List<AlergiaDTO> getAlergias(
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
		
		return alergiaService.findAll();
		//return alergiaService.getByParams(id, descripcion, new PageRequest(page, size));
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id,
			@RequestBody AlergiaDTO alergia) {
		alergiaService.update(alergia);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) {
		alergiaService.delete(id);
	}

}
