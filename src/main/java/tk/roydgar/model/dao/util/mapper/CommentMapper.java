package tk.roydgar.model.dao.util.mapper;

import org.springframework.jdbc.core.RowMapper;
import tk.roydgar.model.dao.util.constants.comment.CommentColumnNames;
import tk.roydgar.model.entity.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int i) throws SQLException {
        Integer id = rs.getInt(CommentColumnNames.ID);
        String text = rs.getString(CommentColumnNames.TEXT);
        Integer mark    = rs.getInt(CommentColumnNames.MARK);
        Integer usefulness = rs.getInt(CommentColumnNames.USEFULNESS);

        return Comment.builder().id(id).text(text).mark(mark).usefulness(usefulness).build();
    }

}
