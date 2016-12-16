package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.entities.Colours;

public interface ColoursDao{
	Colours findById(int id);

	void saveColours(Colours colours);
	
	void deleteColoursById(String idcolours);
	
	List<Colours> findAllColours();

	Colours findColoursById(String idcolours);

}
