package world.inmyopinion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.inmyopinion.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {
	
	Category findById(Long id);
	
	List<Category> findByTextIgnoreCaseContaining(String categoryName);
	
	void deleteById(Long id);
	
}
