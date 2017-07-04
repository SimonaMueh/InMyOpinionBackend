package world.inmyopinion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.inmyopinion.domain.Topic;
import world.inmyopinion.domain.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

	Optional<Vote> findById(Long id);
	
	List<Vote> findByTopic(Topic topic);
	
	List<Vote> findByIp(String ip);

}
