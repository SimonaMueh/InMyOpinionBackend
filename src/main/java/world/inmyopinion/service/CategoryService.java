package world.inmyopinion.service;

import java.util.List;

import world.inmyopinion.domain.Category;
import world.inmyopinion.domain.Topic;

public interface CategoryService {

	Category findById(Long id);
		
	List<Category> findByTextIgnoreCaseContaining(String categoryName);
	
	void deleteById(Long id);
	
	Category createNew(Category category);
	
	List<Category> findAll();	

	Category createNewTopic(Topic topic, Category category);
}
