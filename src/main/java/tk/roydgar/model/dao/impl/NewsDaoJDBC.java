package tk.roydgar.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.roydgar.model.dao.NewsDao;
import tk.roydgar.model.dao.util.constants.news.NewsQueries;
import tk.roydgar.model.dao.util.mapper.NewsMapper;
import tk.roydgar.model.entity.News;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsDaoJDBC implements NewsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findByClientId(int clientId) {
        return jdbcTemplate.query(NewsQueries.FIND_BY_CLIENT_ID, new NewsMapper(), clientId);
    }

    @Override
    public void create(News news, int clientId) {
        jdbcTemplate.update(NewsQueries.CREATE,
                news.getName(), news.getText(), news.getPictureURL(),
                news.getTime(), clientId);
    }

    @Override
    public Optional<News> findById(int id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(
                    NewsQueries.FIND_BY_ID, new NewsMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<News> findAll() {
        return jdbcTemplate.query(NewsQueries.FIND_ALL, new NewsMapper());
    }

    @Override
    public void update(News entity, int id) {
        jdbcTemplate.update(NewsQueries.UPDATE,
                entity.getName(), entity.getText(), entity.getPictureURL(),
                entity.getText(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(NewsQueries.DELETE, id);
    }
}
