package tk.roydgar.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.roydgar.model.dao.CommentDao;
import tk.roydgar.model.dao.util.constants.comment.CommentQueries;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeQueries;
import tk.roydgar.model.dao.util.mapper.CommentMapper;
import tk.roydgar.model.dao.util.mapper.WorkTimeMapper;
import tk.roydgar.model.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDaoJDBC implements CommentDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> findByClientId(int clientId) {
        return jdbcTemplate.query(CommentQueries.FIND_BY_CLIENT_ID, new CommentMapper(), clientId);
    }

    @Override
    public void create(Comment comment, int clientId) {
        jdbcTemplate.update(CommentQueries.CREATE, comment.getName(), comment.getText(), comment.getMark(), clientId);
    }

    @Override
    public Optional<Comment> findById(int id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(
                   CommentQueries.FIND_BY_ID, new CommentMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query(CommentQueries.FIND_ALL, new CommentMapper());
    }

    @Override
    public void update(Comment entity, int id) {
        jdbcTemplate.update(CommentQueries.UPDATE,
                entity.getName(), entity.getText(), entity.getMark(), id);

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(CommentQueries.DELETE, id);
    }
}
