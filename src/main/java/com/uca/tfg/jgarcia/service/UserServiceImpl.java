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
@Service("userService")
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDAO userDao;

	@Autowired
	private DozerBeanMapper dozer;

	
	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		final Iterable<User> findAll = userDao.findAll();
		final Iterator<User> iterator = findAll.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User b = iterator.next();
			final UserDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public UserDTO transform(User user) {
		return dozer.map(user, UserDTO.class);
	}

	@Override
	public User transform(UserDTO user) {
		return dozer.map(user, User.class);
	}
	
	@Override
	public List<UserDTO> transform(List<User> user) {	
		final Iterator<User> iterator = user.iterator();
		final List<UserDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final User b = iterator.next();
			final UserDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public UserDTO create(UserDTO user) {
		User b = transform(user);
		
		return transform(userDao.save(b));
	}

	@Override
	public User getById(Integer id) {
		User b = userDao.findOne(id);
		return b;
	}
	
	@Override
	public UserDTO getByIdDTO(Integer id){
		User b = userDao.findOne(id);
		UserDTO bDTO = transform(b);
		return bDTO;
	}
	

	@Override
	public void update(UserDTO user){	
		User b = transform(user);
		userDao.save(b);
	}

	@Override
	public void delete(Integer id){
		User b = userDao.findOne(id);
		userDao.delete(b);
	}

	@Override
	public List<UserDTO> getByParams(int id, String nombre, String apellido, String email,Date fecha_nacimiento, Pageable pageable) {
		List<UserDTO> b = transform(userDao.findParams(id, nombre, apellido, email,fecha_nacimiento, pageable));
		return b;
	}

	@Override
	public List<Alergia> getAlergiaById(Integer user_id) {
		List<Alergia> alergias = userDao.getAlergiaUser(user_id).getAlergias();
		return alergias;
	}

	
}
