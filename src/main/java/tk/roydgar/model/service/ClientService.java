package tk.roydgar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientDao clientDao;
    private WorkTimeDao workTimeDao;

    @Autowired
    public ClientService(ClientDao clientDao, WorkTimeDao workTimeDao) {
        this.clientDao = clientDao;
        this.workTimeDao = workTimeDao;
    }

    public Optional<Client> login(String login, String password) {

        return clientDao.login(login, password);
    }

    public Optional<Client> findByLogin(String login) {
        return clientDao.findByLogin(login);
    }

    public Optional<Client> findByName(String name) {
        Optional<Client> client = clientDao.findByName(name);

        if (!client.isPresent()) {
            return Optional.empty();
        }

        client.get().setWorkDays(workTimeDao.findByClientId(client.get().getId()));
        return client;
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

    public List<Client> findAll() { return clientDao.findAll(); }

    public void update(Client entity, int id) {
        clientDao.update(entity, id);
    }

    public void delete(int id) {
        clientDao.delete(id);
    }

}
