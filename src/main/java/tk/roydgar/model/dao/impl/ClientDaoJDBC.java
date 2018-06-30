package tk.roydgar.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.util.constants.client.ClientQueries;
import tk.roydgar.model.dao.util.mapper.ClientMapper;
import tk.roydgar.model.entity.Client;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDaoJDBC implements ClientDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Client> login(String login, String password) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(ClientQueries.LOGIN,
                    new ClientMapper(), login, password));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Client> findByLogin(String login) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(ClientQueries.FIND_BY_LOGIN,
                    new ClientMapper(), login));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Client> findByName(String name) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(ClientQueries.FIND_BY_NAME,
                    new ClientMapper(), name));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean clientExists(String login) {
        try {
            jdbcTemplate.queryForObject(ClientQueries.FIND_BY_LOGIN, new ClientMapper(), login);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public void create(Client client) {
        jdbcTemplate.update(ClientQueries.CREATE,
                client.getLogin(), client.getPassword(), client.getName(),
                client.getPhone(), client.getEmail(), client.getRegistrationDate(),
                client.getAddress());
    }

    @Override
    public Optional<Client> findById(int id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(
                    ClientQueries.FIND_BY_ID, new ClientMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query(ClientQueries.FIND_ALL, new ClientMapper());
    }

    @Override
    public void update(Client entity, int id) {
        jdbcTemplate.update(ClientQueries.UPDATE,
                entity.getLogin(), entity.getPassword(), entity.getName(),
                entity.getPhone(), entity.getEmail(), entity.getAddress(),
                id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(ClientQueries.DELETE, id);
    }

}
