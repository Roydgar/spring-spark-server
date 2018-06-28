package tk.roydgar.model.dao.util.mapper;

import org.springframework.jdbc.core.RowMapper;
import tk.roydgar.model.dao.util.constants.news.NewsColumnNames;
import tk.roydgar.model.entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class NewsMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt(NewsColumnNames.ID);
        String name = rs.getString(NewsColumnNames.NAME);
        String text = rs.getString(NewsColumnNames.TEXT);
        String pictureURL = rs.getString(NewsColumnNames.PICTURE_URL);
        LocalDateTime time = rs.getTimestamp(NewsColumnNames.time).toLocalDateTime();

        return News.builder().id(id).name(name).text(text)
                .pictureURL(pictureURL).time(time).build();
    }

}
