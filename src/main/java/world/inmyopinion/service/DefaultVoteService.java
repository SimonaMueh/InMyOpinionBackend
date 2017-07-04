package world.inmyopinion.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;
import world.inmyopinion.repository.VoteRepository;

@Transactional(readOnly = true)
@Service
public class DefaultVoteService implements VoteService {
	
	private VoteRepository repository;

	@Autowired
	public DefaultVoteService (VoteRepository repository){
		this.repository = repository;
	}
	

	@Override
	public Vote findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Could not find Vote with ID [" + id + "]"));
	}

	@Override
	public List<Vote> findByTopic(Topic topic) {
		return repository.findByTopic(topic);
	}

	@Override
	public List<Vote> findByIp(String ip) {
		return repository.findByIp(ip);
	}

	@Override
	public List<Vote> findAll() {
		return repository.findAll();
	}

	@Override
	public Vote createNew(Vote vote) {
		vote.setId(null);
		return repository.save(vote);
	}



}
