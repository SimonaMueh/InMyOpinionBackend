package world.inmyopinion.service;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.repository.TopicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test-data.sql")
public class TopicServiceTest {

	@Autowired
	TopicService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	TopicRepository repository;


	private static final int TOPICS_IN_TEST_DATA = 3;
	
	@Test
	public void findAll() {
//		assertThat(service.findAll()).hasSize(TOPICS_IN_TEST_DATA);
		assertThat(repository.findAll().size()).isEqualTo(TOPICS_IN_TEST_DATA);
	}


}
