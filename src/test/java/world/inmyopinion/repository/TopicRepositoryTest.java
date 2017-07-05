package world.inmyopinion.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

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
	
//	@Test
//	public void findByDateCreated(){
//		LocalDateTime dateCreated = repository.findById(3L).getDateCreated();
//		assertThat(repository.findByDateCreated(dateCreated)).isEqualTo(repository.findById(3L));
//	}
	
	@Test
	public void deleteByToken(){
		repository.deleteByToken("a2873348-029b-4a84-86f5-932aa5f80331");
		assertThat(repository.findAll().size()).isEqualTo(TOPICS_IN_TEST_DATA -1);
	}

}
