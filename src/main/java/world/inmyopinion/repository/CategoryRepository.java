package world.inmyopinion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.inmyopinion.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {
	
	Optional<Category> findbyId(Long id);
	
	List<Category> findByText(String categoryName);
	
	void deleteById(Long id);
	
}
