package tk.roydgar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.CommentDao;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.dao.util.NewsDao;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.dao.util.constants.comment.CommentQueries;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeQueries;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.Comment;
import tk.roydgar.model.entity.News;
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

	@Autowired
	CommentDao commentDao;

	@Autowired
	Comment testComment;

	@Autowired
	NewsDao newsDao;

	@Autowired
	News testNews;

	@Test
	public void createLocalHostTable() {
		clientDao.create(testClient);

		int id = clientDao.findByLogin(testClient.getLogin()).get().getId();
		workTimeDao.create(testWorkTime, id);
		commentDao.create(testComment, id);
		newsDao.create(testNews, id);
	}


}
