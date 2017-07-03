package world.inmyopinion.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EntityTests {

	@Test
	public void testConstructors() {
		Category category = new Category("color");
		Topic topic = new Topic( "I want to eat fish", category, "token");
		Vote vote = new Vote (topic, true);
				

		assertThat(topic.getCategory().equals(category));
		assertThat(topic.getVotes().contains(vote));
		
	}

}