package world.inmyopinion.service;

import java.util.List;

import world.inmyopinion.domain.Category;

public interface CategoryService {

	Category findById (Long id);
		
	List<Category> findByTextIgnoreCaseContaining(String categoryName);
	
	void deleteById(Long id);
	
	Category createNew(Category category);
	
	List<Category> findAll();	

}
