package tk.roydgar.model.dao;

import tk.roydgar.model.entity.Comment;

import java.util.List;

public interface CommentDao extends GenericDao<Comment> {
    List<Comment> findByClientId(int clientId);

    void create(Comment comment, int clientId);
}
