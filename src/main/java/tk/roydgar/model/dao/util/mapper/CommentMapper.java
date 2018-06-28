package tk.roydgar.model.dao.util.mapper;

import org.springframework.jdbc.core.RowMapper;
import tk.roydgar.model.dao.util.constants.comment.CommentColumnNames;
import tk.roydgar.model.entity.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt(CommentColumnNames.ID);
        String name = rs.getString(CommentColumnNames.NAME);
        String text = rs.getString(CommentColumnNames.TEXT);
        int mark    = rs.getInt(CommentColumnNames.MARK);

        return Comment.builder().id(id).name(name).text(text).mark(mark).build();
    }
}
