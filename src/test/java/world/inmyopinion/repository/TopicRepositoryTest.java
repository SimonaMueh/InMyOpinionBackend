package world.inmyopinion.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import world.inmyopinion.domain.Topic;
import world.inmyopinion.repository.TopicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql("/test-data.sql")
public class TopicRepositoryTest {


	private static final int TOPICS_IN_TEST_DATA = 3;

	@Autowired
	TopicRepository repository;

	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(TOPICS_IN_TEST_DATA);
	}

	@Test
	public void findById() {
		assertThat(repository.findById(1L).getText()).isEqualTo("I like pink!");
	}
	
	@Test
	public void findByToken() {
		assertThat(repository.findByToken("8df15654-21f2-42ae-85f0-d7802c8a6d4c").getText()).isEqualTo("I like chinese food.");
	}

	@Test
	public void findByTextIgnoreCaseContaining(){
		assertThat(repository.findByTextIgnoreCaseContaining("I like")).size().isEqualTo(3);
	}
	
	@Test
	public void findByDateCreated(){
		LocalDateTime dateCreated = repository.findById(3L).getDateCreated();
		assertThat(repository.findByDateCreated(dateCreated))
	}

}
