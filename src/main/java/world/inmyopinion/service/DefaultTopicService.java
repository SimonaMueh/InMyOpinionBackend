package world.inmyopinion.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.domain.Topic;
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
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Could not find Topic with ID [" + id + "]"));
	}

	@Override
	public List<Topic> findByCategory(String categoryName) {
		return repository.findByCategory(categoryName);
	}

	@Override
	public List<Topic> findByToken(String token) {
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
	public Topic createNew(Topic topic) {
		// 2 steps before creating the topic in database:
		// First, set id to null to make sure we're creating a new topic and not
		// updating an existing one.
		topic.setId(null);
		// Now we store the topic in the database
		return repository.save(topic);
	}

	@Override
	public List<Topic> findAll() {
		return repository.findAll();
	}
	

}
