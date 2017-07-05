package world.inmyopinion.service;



import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import world.inmyopinion.domain.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test-data.sql")
public class TopicServiceTest {

	@Autowired
	TopicService service;
	
	@Autowired
	CategoryService categoryService;
	
	private static final int TOPICS_IN_TEST_DATA = 3;
	
	@Test
	public void findAll() {
//		assertThat(service.findAll()).hasSize(TOPICS_IN_TEST_DATA);
		assertThat(service.findAll().size()).isEqualTo(TOPICS_IN_TEST_DATA);
	}
	
	@Test
	public void findById() {
		Long id = service.findById(1L).getId();
		assertThat(service.findById(id).getCategory().getText()).isEqualTo("world");	
	}
	
//	@Test
//	public void findByCategory() {
//		List<Category> category = categoryService.findAll();
//		assertThat(service.findByCategory(category.get(0).getId())).isEqualTo(service.findAll().get(0));	
//	}

	@Test
	public void findByToken() {
		String token = service.findById(1L).getToken();
		assertThat(service.findByToken(token).getText()).isEqualTo("I like  pink!");	
	}
	
	@Test
	public void findByTextIgnoreCaseContaining(){
		Topic topic = service.findByTextIgnoreCaseContaining("pink").get(0);
		assertThat(topic.getText()).isEqualTo("I like  pink!");
		assertThat(service.findByTextIgnoreCaseContaining("i").size()).isEqualTo(3);
	}
	
	@Test
	public void findByDateCreated(){
//		Topic topic = service.findByDateCreated('2016-01-26 00:00:00.00');
		LocalDateTime ldt = LocalDateTime.of(2016, 01, 26, 00, 00);
		List<Topic> topics = service.findByDateCreated(ldt);
		assertThat(topics.size()).isEqualTo(1);
	}
	
	@Test
	public void deleteByToken() {
		String token = service.findById(1L).getToken();
		service.deleteByToken(token);
		assertThat(service.findAll().size()).isEqualTo(TOPICS_IN_TEST_DATA -1);
	}

}
