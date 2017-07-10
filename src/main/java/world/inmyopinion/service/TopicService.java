package world.inmyopinion.service;

import java.time.LocalDateTime;
import java.util.List;

import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;


public interface TopicService {
	
	
//	Optional<Topic> findById(Long id); change the interface to match the class because we assume class is implemented correctly
	
	Topic findById(Long id);
	
//	List<Topic> findByCategory(Long id);
	
	Topic findByToken(String token);
	
	List<Topic> findByTextIgnoreCaseContaining(String text);
	
	List<Topic> findByDateCreated(LocalDateTime dateCreated);	
	
	void deleteByToken(String token);
	
    Topic createNew(Topic topic);
	
	List<Topic> findAll();

	Topic createNewVote(Vote vote, Topic topic);	
	
}
