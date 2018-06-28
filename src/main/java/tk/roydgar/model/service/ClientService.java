package tk.roydgar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.entity.Client;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public Optional<Client> login(String login, String password) {
        return clientDao.login(login, password);
    }


    public Optional<Client> findClientByLogin(String login) {
        return clientDao.findByLogin(login);
    }


    public boolean clientExists(String login) {
        return clientDao.clientExists(login);
    }


    public void create(Client client) {
        clientDao.create(client);
    }


    public Optional<Client> findById(int id) {
        return clientDao.findById(id);
    }


    public List<Client> findAll() {
        return clientDao.findAll();
    }


    public void update(Client entity, int id) {
        clientDao.update(entity, id);
    }


    public void delete(int id) {
        clientDao.delete(id);
    }

}
