package world.inmyopinion.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.inmyopinion.domain.Category;
import world.inmyopinion.domain.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	// Optional does not return null but throws NoSuchElemetException
	
	Optional<Topic> findById(Long id);
	
	List<Topic> findByCategory(String categoryName);
	
	List<Topic> findByToken(String token);
	
	List<Topic> findByTextIgnoreCaseContaining(String text);
	
	List<Topic> findByDateCreated(LocalDateTime dateCreated);	
	
	void deleteByToken(String token);
	

}
