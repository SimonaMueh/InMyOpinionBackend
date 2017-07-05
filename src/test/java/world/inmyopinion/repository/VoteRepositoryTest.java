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
public class VoteRepositoryTest {
	
	private static final int VOTES_IN_TEST_DATA = 3;

	@Autowired
	VoteRepository repository;

	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(VOTES_IN_TEST_DATA);
	}
	
	@Test
	public void findByIp() {
		assertThat(repository.findById(1L).getIp()).isEqualTo("3.86.150.224");
	}



}
