package world.inmyopinion.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.domain.Category;
import world.inmyopinion.repository.CategoryRepository;

@Transactional(readOnly = true)
@Service
public class DefaultCategoryService implements CategoryService {

	private CategoryRepository repository;

	@Autowired
	public DefaultCategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Category findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Category> findByTextIgnoreCaseContaining(String categoryName) {
		return repository.findByTextIgnoreCaseContaining(categoryName);
	}


	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Category createNew(Category category) {
		category.setId(null);
		return repository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}


}
