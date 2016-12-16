package com.stores.app.storesecond.service;

import java.util.List;




import com.stores.app.storesecond.entities.Colours;

public interface ColoursService {
	Colours findById(int id);
	
	void saveColours(Colours colours);
	
	void updateColours(Colours colours);
	
	void deleteColoursById(String idcolours);

	List<Colours> findAllColours(); 
	
	Colours findColoursById(String idcolours);

	boolean isColoursIdUnique(Integer id, String idcolours);

}
