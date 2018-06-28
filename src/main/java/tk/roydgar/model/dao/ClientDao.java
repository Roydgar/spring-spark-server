package tk.roydgar.model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tk.roydgar.model.entity.Client;

import java.util.Optional;

public interface ClientDao extends GenericDao<Client> {

    void create(Client client);
    Optional<Client> login(String login, String password);
    Optional<Client> findByLogin(String login);
    boolean clientExists(String login);

}
