package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.model.Colour;

public interface ColourService {
	Colour findById(int id);
	
	void saveColour(Colour colour);
	
	void updateColour(Colour colour);
	
	void deleteColourById(String idColour);

	List<Colour> findAllColours(); 
	
	Colour findColourById(String idColour);

	

}
