package tk.roydgar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.roydgar.model.dao.CommentDao;
import tk.roydgar.model.entity.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> findByClientId(int clientId) {
        return commentDao.findByClientId(clientId);
    }

    public void create(Comment comment, int clientId) {
        commentDao.create(comment, clientId);
    }

    public Optional<Comment> findById(int id) {
        return commentDao.findById(id);
    }

    public List<Comment> findAll() {
        return commentDao.findAll();
    }


    public void update(Comment entity, int id) {
        commentDao.update(entity, id);
    }

    public void delete(int id) {
        commentDao.delete(id);
    }

}
