package world.inmyopinion.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql("/test-data.sql")
public class CategoryRepositoryTest {

	
	private static final int CATEGORIES_IN_TEST_DATA = 3;

	@Autowired
	CategoryRepository repository;

	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(CATEGORIES_IN_TEST_DATA);
	}
	
	@Test
	public void findById() {
		assertThat(repository.findById(1L).getText()).isEqualTo("world");
	}
	
	@Test
	public void findByTextIgnoreCaseContaining(){
		assertThat(repository.findByTextIgnoreCaseContaining("l")).size().isEqualTo(3);
		assertThat(repository.findByTextIgnoreCaseContaining("hello")).size().isEqualTo(0);
	}
	
	@Test
	public void deleteById(){
		repository.deleteById(3L);
		assertThat(repository.findAll().size()).isEqualTo(CATEGORIES_IN_TEST_DATA -1);
		assertThat(repository.findByTextIgnoreCaseContaining("people")).size().isEqualTo(0);
	}


}
