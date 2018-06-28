package tk.roydgar.model.dao.impl;
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
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.Comment;
import tk.roydgar.model.entity.News;
import tk.roydgar.model.entity.workTime.WorkTime;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    /*@Autowired
    ClientDao clientDao;

    @Autowired
    NewsDao newsDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    WorkTimeDao workTimeDao;

    @Autowired
    Client testClient;

    @Autowired
    News testNews;

    @Autowired
    Comment testComment;

    @Autowired
    WorkTime testWorkTime;


    @Test
    public void test() {
       clientDao.create(testClient);
       int id = clientDao.findByLogin(testClient.getLogin()).get().getId();
       commentDao.create(testComment, id);
       newsDao.create(testNews, id);
       workTimeDao.create(testWorkTime, id);
    }
 */

   @Test
    public void test1() {}
}
