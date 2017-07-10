package world.inmyopinion.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;
import world.inmyopinion.repository.TopicRepository;

@Transactional(readOnly = true)
@Service
public class DefaultTopicService implements TopicService {
	
	private final TopicRepository repository;
	
	@Autowired
	public DefaultTopicService (TopicRepository repository){
		this.repository = repository;
	}
		
	@Override
	
	public Topic findById(Long id) {
		return repository.findById(id);
	}

//	@Override
//	public List<Topic> findByCategory(Long id) {
//		return repository.findByCategory(id);
//	}

	@Override
	public Topic findByToken(String token) {
		return repository.findByToken(token);
	}

	@Override
	public List<Topic> findByTextIgnoreCaseContaining(String text) {
		return repository.findByTextIgnoreCaseContaining(text);
	}

	@Override
	public List<Topic> findByDateCreated(LocalDateTime dateCreated) {
		return repository.findByDateCreated(dateCreated);
	}

	@Override
	public void deleteByToken(String token) {
		repository.deleteByToken(token);
	}

	@Override
	public List<Topic> findAll() {
		return repository.findAll();
	}
	
	public Topic createNew(Topic topic) {
		topic.setId(null);
		return repository.save(topic);
	}
	
	@Override
	public Topic createNewVote(Vote vote, Topic topic) {
		topic.addVote(vote);
		return topic;
	}

}
