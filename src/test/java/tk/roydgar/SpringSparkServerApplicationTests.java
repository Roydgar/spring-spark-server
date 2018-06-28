package tk.roydgar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.entity.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSparkServerApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ClientDao clientDao;

	@Autowired
	Client testClient;

	@Test
	public void createLocalHostTable() {
		jdbcTemplate.update(ClientQueries.CREATE_TABLE);
		clientDao.create(testClient);
		System.out.println(clientDao.findAll());
	}

}
