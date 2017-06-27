package com.uca.tfg.jgarcia.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import com.uca.tfg.jgarcia.model.*;
import com.uca.tfg.jgarcia.dto.*;
import com.uca.tfg.jgarcia.dao.*;
@Service("alergiaService")

public class AlergiaServiceImpl implements AlergiaService{ 

	@Autowired
	private AlergiaDAO alergiaDao;

	@Autowired
	private DozerBeanMapper dozer;

	
	@Transactional(readOnly = true)
	public List<AlergiaDTO> findAll() {
		final Iterable<Alergia> findAll = alergiaDao.findAll();
		final Iterator<Alergia> iterator = findAll.iterator();
		final List<AlergiaDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Alergia b = iterator.next();
			final AlergiaDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	public AlergiaDTO transform(Alergia alergia) {
		return dozer.map(alergia, AlergiaDTO.class);
	}

	public Alergia transform(AlergiaDTO alergia) {
		return dozer.map(alergia, Alergia.class);
	}
	
	public List<AlergiaDTO> transform(List<Alergia> alergia) {	
		final Iterator<Alergia> iterator = alergia.iterator();
		final List<AlergiaDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Alergia b = iterator.next();
			final AlergiaDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	public AlergiaDTO create(AlergiaDTO alergia) {
		Alergia b = transform(alergia);
		
		return transform(alergiaDao.save(b));
	}

	public Alergia getById(Integer id) {
		Alergia b = alergiaDao.findOne(id);
		return b;
	}
	
	public AlergiaDTO getByIdDTO(Integer id){
		Alergia b = alergiaDao.findOne(id);
		AlergiaDTO bDTO = transform(b);
		return bDTO;
	}
	

	public void update(AlergiaDTO alergia){	
		Alergia b = transform(alergia);
		alergiaDao.save(b);
	}

	public void delete(Integer id){
		Alergia b = alergiaDao.findOne(id);
		alergiaDao.delete(b);
	}

	public List<AlergiaDTO> getByParams(String id, String descripcion, Pageable pageable) {
		List<AlergiaDTO> b = transform(alergiaDao.findParams(id, descripcion, pageable));
		return b;
	}

	
}
