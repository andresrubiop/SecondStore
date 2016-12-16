package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.ColoursDao;
import com.stores.app.storesecond.entities.Colours;

@Service("coloursService")
@Transactional
public class ColoursServiceImpl implements ColoursService{
	@Autowired
	private ColoursDao dao;

	@Override
	public Colours findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveColours(Colours colours) {
		dao.saveColours(colours);
		
	}

	@Override
	public void updateColours(Colours colours) {
		Colours entity = dao.findById(colours.getIdColours());
		if(entity!=null){
			entity.setNameColours(colours.getNameColours());
			
		}
		
	}

	@Override
	public void deleteColoursById(String idcolours) {
		dao.deleteColoursById(idcolours);
		
	}

	@Override
	public List<Colours> findAllColours() {
		return dao.findAllColours();
	}

	@Override
	public Colours findColoursById(String idcolours) {
		return dao.findColoursById(idcolours);
	}

	@Override
	public boolean isColoursIdUnique(Integer id, String idcolours) {
		Colours colours = findColoursById(idcolours);
		return ( colours == null || ((id != null) && (colours.getIdColours() == id)));
	}

}
