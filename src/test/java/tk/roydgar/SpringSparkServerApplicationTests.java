package tk.roydgar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeQueries;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.time.DayOfWeek;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSparkServerApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ClientDao clientDao;

	@Autowired
	WorkTimeDao workTimeDao;

	@Autowired
	Client testClient;

	@Autowired
	WorkTime testWorkTime;

	@Test
	public void createLocalHostTable() {
		jdbcTemplate.update(ClientQueries.CREATE_TABLE);
		jdbcTemplate.update(WorkTimeQueries.CREATE_TABLE);
		clientDao.create(testClient);

		int id = clientDao.findByLogin(testClient.getLogin()).get().getId();
		workTimeDao.create(testWorkTime, id);
	}


}
