package tk.roydgar.model.dao;

import tk.roydgar.model.dao.GenericDao;
import tk.roydgar.model.entity.News;

import java.util.List;

public interface NewsDao extends GenericDao<News> {
    List<News> findByClientId(int clientId);

    void create(News news, int clientId);
}
