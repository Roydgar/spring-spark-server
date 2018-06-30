package tk.roydgar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.roydgar.model.dao.NewsDao;
import tk.roydgar.model.entity.News;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public List<News> findByClientId(int clientId) {
        return newsDao.findByClientId(clientId);
    }

    public void create(News news, int clientId) {
        newsDao.create(news, clientId);
    }

    public Optional<News> findById(int id) {
        return newsDao.findById(id);
    }

    public List<News> findAll() {
        return newsDao.findAll();
    }

    public void update(News entity, int id) {
        newsDao.update(entity, id);
    }

    public void delete(int id) {
        newsDao.delete(id);
    }
}
