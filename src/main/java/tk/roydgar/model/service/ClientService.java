package tk.roydgar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.dao.CommentDao;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.dao.util.NewsDao;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    private ClientDao clientDao;

    private WorkTimeDao workTimeDao;

    private CommentDao commentDao;

    private NewsDao newsDao;

    @Autowired
    public ClientService(ClientDao clientDao, WorkTimeDao workTimeDao, CommentDao commentDao, NewsDao newsDao) {
        this.clientDao = clientDao;
        this.workTimeDao = workTimeDao;
        this.commentDao = commentDao;
        this.newsDao = newsDao;
    }

    public Optional<Client> login(String login, String password) {
        Optional<Client> client = clientDao.login(login, password);

        if (!client.isPresent()) {
            return Optional.empty();
        }

        client.get().setWorkDays(workTimeDao.findByClientId(client.get().getId()));
        client.get().setComments(commentDao.findByClientId(client.get().getId()));
        client.get().setNews(newsDao.findNByClientId(client.get().getId()));
        return client;
    }

    public Optional<Client> findClientByLogin(String login) {
        Optional<Client> client = clientDao.findByLogin(login);

        if (!client.isPresent()) {
            return Optional.empty();
        }

        client.get().setWorkDays(workTimeDao.findByClientId(client.get().getId()));
        client.get().setComments(commentDao.findByClientId(client.get().getId()));
        client.get().setNews(newsDao.findNByClientId(client.get().getId()));

        return client;
    }

    public boolean clientExists(String login) {
        return clientDao.clientExists(login);
    }

    public void create(Client client) {
        clientDao.create(client);
    }

    public Optional<Client> findById(int id) {
        Optional<Client> client = clientDao.findById(id);

        if (!client.isPresent()) {
            return Optional.empty();
        }

        client.get().setWorkDays(workTimeDao.findByClientId(client.get().getId()));
        client.get().setComments(commentDao.findByClientId(client.get().getId()));
        client.get().setNews(newsDao.findNByClientId(client.get().getId()));

        return client;
    }

    public List<Client> findAll() {
        List<Client> clients = clientDao.findAll();

        clients.forEach(client -> {
            client.setWorkDays(workTimeDao.findByClientId(client.getId()));
            client.setComments(commentDao.findByClientId(client.getId()));
            client.setNews(newsDao.findNByClientId(client.getId()));
        });
        return clients;
    }

    public void update(Client entity, int id) {
        clientDao.update(entity, id);
    }

    public void delete(int id) {
        clientDao.delete(id);
    }

}
