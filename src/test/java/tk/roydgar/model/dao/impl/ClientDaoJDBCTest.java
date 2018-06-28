package tk.roydgar.model.dao.impl;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.util.constants.ConnectionConstants;
import tk.roydgar.model.dao.util.constants.GeneralQueries;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.entity.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClientDaoJDBCTest{

    @Autowired
    private ClientDao clientDao;

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    private Client testClient;

    private static final int TEST_CLIENT_ID = 1;

    @BeforeClass
    public static void createTable() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(ConnectionConstants.LOCAL_URL);
        dataSource.setUsername(ConnectionConstants.LOCAL_USER);
        dataSource.setPassword(ConnectionConstants.LOCAL_PASSWORD);
        dataSource.setDriverClassName(ConnectionConstants.MYSQL_JDBC_DRIVER);


        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(ClientQueries.CREATE_TABLE);

    }

    @AfterClass
    public static void dropTable() {
        jdbcTemplate.update(ClientQueries.DROP_TABLE);
    }


    @Before
    public void createTestClient() {
        clientDao.create(testClient);
    }

    @After
    public void truncateTable() {
        jdbcTemplate.update(ClientQueries.TRUNCATE_TABLE);
    }

    //login() tests
    @Test
    public void loginSuccess() {
        Optional<Client> client = clientDao.login(testClient.getLogin(), testClient.getPassword());
        assertTrue(client.isPresent());
    }

    @Test
    public void loginFailedClientLoginIsWrong() {
        Optional<Client> client = clientDao.login("any wrong login", testClient.getPassword());
        assertFalse(client.isPresent());
    }

    @Test
    public void loginFailedClientPasswordIsWrong() {
        Optional<Client> client = clientDao.login(testClient.getLogin(), "any wrong password");
        assertFalse(client.isPresent());
    }

    @Test
    public void loginFailedClientLoginAndPasswordAreWrong() {
        Optional<Client> client = clientDao.login("any wrong login", "any wrong password");
        assertFalse(client.isPresent());
    }

    //findClient() tests
    @Test
    public void findClientByExistingLogin() {
        Optional<Client> client = clientDao.findByLogin(testClient.getLogin());
        assertTrue(client.isPresent());
    }

    @Test
    public void findClientByNonExistingLogin() {
        Optional<Client> client = clientDao.findByLogin("any wrong login");
        assertFalse(client.isPresent());
    }

    //clientExists() tests
    @Test
    public void clientExistsWithExistingLogin() {
        assertTrue(clientDao.clientExists(testClient.getLogin()));
    }

    @Test
    public void clientDoesntExistWithWrongLogin() {
        assertFalse(clientDao.clientExists("any wrong login"));
    }

    //findById() tests
    @Test
    public void findByExistingIdReturnsCorrectClient() {
        Optional<Client> client = clientDao.findById(TEST_CLIENT_ID);
        assertTrue(client.isPresent());
    }

    @Test
    public void findByNonExistingIdDoesntReturnClient() {
        Optional<Client> client = clientDao.findById(-100);
        assertFalse(client.isPresent());
    }

    //findAll() tests
    @Test
    public void findAllReturnsAllClients() {
        List<Client> expected = new ArrayList<>();
        expected.add(testClient);
        expected.add(testClient);

        clientDao.create(testClient);
        List<Client> actual = clientDao.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void findAllReturnsNoClientsIfTableIsEmpty() {
        clientDao.delete( TEST_CLIENT_ID);
        List<Client> actual = clientDao.findAll();
        assertTrue(actual.isEmpty());
    }

    //update() tests
    @Test
    public void updateDoesntChangeId() {
        Client client = Client.builder()
                .name("sto").password("0000")
                .login("updatedClient").phone("88005555535")
                .registrationDate(LocalDateTime.now())
                .email("royd@mail.ru")
                .address("SDFSDF").build();

        Optional<Client> expected = clientDao.findByLogin(testClient.getLogin());
        clientDao.update(client, TEST_CLIENT_ID);

        Optional<Client> actual = clientDao.findByLogin("updatedClient");

        assertTrue(expected.isPresent());
        assertTrue(actual.isPresent());
        assertEquals(actual.get().getId(), expected.get().getId());
    }

    @Test
    public void updateUpdatesAllFieldsCorrectly() {
        Client expected = Client.builder()
                .name("sto2").password("1111")
                .login("updatedclient").phone("0000")
                .registrationDate(LocalDateTime.now())
                .email("roydgar@mail.ru")
                .address("SDFSDF").build();

        clientDao.update(expected, TEST_CLIENT_ID);

        Optional<Client> actual = clientDao.findByLogin("updatedClient");

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    public void updateDoesntChangeRegistrationDate() {
        Client expected = Client.builder()
                .name("sto2").password("1111")
                .login("updatedclient").phone("0000")
                .registrationDate(LocalDateTime.now())
                .email("roydgar@mail.ru").address("SDFSDF").build();

        clientDao.update(expected, TEST_CLIENT_ID);
        Optional<Client> actual = clientDao.findByLogin("updatedClient");

        assertTrue(actual.isPresent());
        assertNotEquals(expected.getRegistrationDate(), actual.get().getRegistrationDate());
    }

    //delete() test
    @Test
    public void deleteWorksCorrectlyWithExistingClientId() {
        clientDao.delete(1);

        Optional<Client> client = clientDao.findByLogin(testClient.getLogin());
        assertFalse(client.isPresent());
    }

    @Test
    public void deleteWorksCorrectlyWithNonExistingClientId() {
        clientDao.delete(-100);

        Optional<Client> client = clientDao.findByLogin(testClient.getLogin());
        assertTrue(client.isPresent());
    }




}
