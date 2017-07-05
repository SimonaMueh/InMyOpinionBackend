package world.inmyopinion.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.inmyopinion.domain.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	// Optional does not return null but throws NoSuchElemetException
	
	Topic findById(Long id);
	
//	List<Topic> findByCategory(Long id);
	
	Topic findByToken(String token);
	
	List<Topic> findByTextIgnoreCaseContaining(String text);
	
	List<Topic> findByDateCreated(LocalDateTime dateCreated);	
	
	void deleteByToken(String token);

}
