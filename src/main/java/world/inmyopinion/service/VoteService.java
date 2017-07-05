package world.inmyopinion.service;

import java.util.List;
import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;

public interface VoteService {
	
	Vote findById(Long id);
	
//	List<Vote> findByTopic(Topic topic);
	
	List<Vote> findByIp(String ip);
	
	List<Vote> findAll();
	
	Vote createNew(Vote vote);

}
