package world.inmyopinion.service;

import java.time.LocalDateTime;
import java.util.List;
import world.inmyopinion.domain.Category;
import world.inmyopinion.domain.Topic;

public interface TopicService {
	
	
//	Optional<Topic> findById(Long id); change the interface to match the class because we assume class is implemented correctly
	
	Topic findById(Long id);
	
	List<Topic> findByCategoryIgnoreCaseContaining(Category category);
	
	List<Topic> findByToken(String token);
	
	List<Topic> findByTextIgnoreCaseContaining(String text);
	
	List<Topic> findByDateCreated(LocalDateTime dateCreated);	
	
	void deleteByToken(String token);
	
	Topic createNew(Topic topic);
	
	List<Topic> findAll();	
	
	
}
