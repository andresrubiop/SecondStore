package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.model.Colour;

public interface ColourDao{
	Colour findById(int id);

	void saveColour(Colour colour);
	
	void deleteColourById(String idColour);
	
	List<Colour> findAllColours();

	Colour findColourById(String idColour);

}
