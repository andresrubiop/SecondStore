package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.ColourDao;
import com.stores.app.storesecond.model.Colour;

@Service("colourService")
@Transactional
public class ColourServiceImpl implements ColourService{
	@Autowired
	private ColourDao dao;

	//@Override
	public Colour findById(int id) {
		return dao.findById(id);
	}

	//@Override
	public void saveColour(Colour colour) {
		dao.saveColour(colour);
		
	}

	//@Override
	public void updateColour(Colour colour) {
		Colour entity = dao.findById(colour.getIdColour());
		if(entity!=null){
			entity.setNameColour(colour.getNameColour());
			entity.setValueColour(colour.getValueColour());
			
		}
		
	}

	//@Override
	public void deleteColourById(String idColour) {
		dao.deleteColourById(idColour);
		
	}

	//@Override
	public List<Colour> findAllColours() {
		return dao.findAllColours();
	}

	//@Override
	public Colour findColourById(String idColour) {
		return dao.findColourById(idColour);
	}

	//@Override


}
