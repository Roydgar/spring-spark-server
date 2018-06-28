package tk.roydgar.model.dao.impl;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.dao.util.constants.ConnectionConstants;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeQueries;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.workTime.Day;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WorkTimeDaoJDBCTest {

    @Test
    public void test() {

    }
    /*@Autowired
    private ClientDao clientDao;

    @Autowired
    private WorkTimeDao workTimeDao;

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    private Client testClient;

    @Autowired
    private WorkTime workTime;

    private static final int TEST_CLIENT_ID = 1;

    private static final int TEST_WORK_TIME_ID = 1;

    @BeforeClass
    public static void createTable() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(ConnectionConstants.LOCAL_URL);
        dataSource.setUsername(ConnectionConstants.LOCAL_USER);
        dataSource.setPassword(ConnectionConstants.LOCAL_PASSWORD);
        dataSource.setDriverClassName(ConnectionConstants.MYSQL_JDBC_DRIVER);


        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(ClientQueries.CREATE_TABLE);
        jdbcTemplate.update(WorkTimeQueries.CREATE_TABLE);
    }



    @Before
    public void createTestClient() {
        clientDao.create(testClient);
        workTimeDao.create(workTime, TEST_CLIENT_ID);
    }

    @After
    public void truncateTable() {
        jdbcTemplate.update(WorkTimeQueries.TRUNCATE_TABLE);
    }

    @Test
    public void deleteWorksCorrectlyWithExistingId() {
        workTimeDao.delete(TEST_WORK_TIME_ID);
        Optional<WorkTime> expected = workTimeDao.findById(1);

        assertFalse(expected.isPresent());
    }

    @Test
    public void deleteWorksCorrectlyWithNonExistingId() {
        workTimeDao.delete(-100);
        Optional<WorkTime> expected = workTimeDao.findById(-100);

        assertFalse(expected.isPresent());
    }

    @Test
    public void findAllReturnsAllWorkTimes() {
        List<WorkTime> expected = new ArrayList<>();
        expected.add(workTime);
        expected.add(workTime);

        workTimeDao.create(workTime, TEST_CLIENT_ID);
        List<WorkTime> actual = workTimeDao.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllReturnsNoWorkTimesIfTableIsEmpty() {
        workTimeDao.delete(TEST_WORK_TIME_ID);

        List<WorkTime> actual = workTimeDao.findAll();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void findByExistingIdReturnsCorrectWorkTime() {
        Optional<WorkTime> workTime = workTimeDao.findById(TEST_WORK_TIME_ID);
        assertTrue(workTime.isPresent());
    }

    @Test
    public void findByNonExistingIdDoesntReturnWorkTime() {
        Optional<WorkTime> workTime = workTimeDao.findById(-100);
        assertFalse(workTime.isPresent());
    }

    @Test
    public void updateDoesntChangeId() {
        WorkTime workTime = WorkTime.builder().from(Day.builder()
                .day(DayOfWeek.MONDAY).hour("10").minute("05").build()).to(
                Day.builder().day(DayOfWeek.FRIDAY).hour("20").minute("30").build()).build();

        Optional<WorkTime> expected = workTimeDao.findById(TEST_WORK_TIME_ID);
        workTimeDao.update(workTime,  TEST_WORK_TIME_ID);

        Optional<WorkTime> actual = workTimeDao.findById(TEST_WORK_TIME_ID);

        assertTrue(expected.isPresent());
        assertTrue(actual.isPresent());
        assertTrue(actual.get().getId().equals(expected.get().getId()));
    }

    @Test
    public void findByClientIdWorksCorrectlyForSeveralWorkTimesToOneClient() {
        workTimeDao.create(workTime, 1);

        List<WorkTime> expected = new ArrayList<>();
        expected.add(workTime);
        expected.add(workTime);

        List<WorkTime> actual = workTimeDao.findByClientId(TEST_CLIENT_ID);
        assertEquals(expected, actual);
    }

    @Test
    public void findByClientIdWorksCorrectlyForOneWorkTimeToOneClient() {
        List<WorkTime> expected = new ArrayList<>();
        expected.add(workTime);

        List<WorkTime> actual = workTimeDao.findByClientId(TEST_CLIENT_ID);
        assertEquals(expected, actual);
    }

    @Test
    public void findByClientIdWorksCorrectlyNonExistingWorkTimesToOneClient() {
        workTimeDao.delete(TEST_WORK_TIME_ID);

        List<WorkTime> actual = workTimeDao.findByClientId(TEST_CLIENT_ID);
        assertTrue(actual.isEmpty());
    }
    */
}
