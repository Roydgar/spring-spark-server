package tk.roydgar.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.roydgar.model.dao.WorkTimeDao;
import tk.roydgar.model.dao.util.mapper.ClientMapper;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeQueries;
import tk.roydgar.model.dao.util.mapper.WorkTimeMapper;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkTimeDayJDBC implements WorkTimeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkTimeDayJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<WorkTime> findByClientId(int clientId) {
        return jdbcTemplate.query(WorkTimeQueries.FIND_BY_CLIENT_ID, new WorkTimeMapper(), clientId);
    }

    @Override
    public void create(WorkTime workTime, int clientId) {
        jdbcTemplate.update(WorkTimeQueries.CREATE,
                workTime.getFrom().getDay().toString(), workTime.getFrom().getHour(), workTime.getFrom().getMinute(),
                workTime.getTo().getDay().toString(), workTime.getTo().getHour(), workTime.getTo().getMinute(), clientId);
    }

    @Override
    public Optional<WorkTime> findById(int id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(
                    WorkTimeQueries.FIND_BY_ID, new WorkTimeMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<WorkTime> findAll() {
        return jdbcTemplate.query(WorkTimeQueries.FIND_ALL, new WorkTimeMapper());
    }

    @Override
    public void update(WorkTime entity, int id) {
        jdbcTemplate.update(WorkTimeQueries.UPDATE,
                entity.getFrom().getDay().toString(), entity.getFrom().getHour(), entity.getFrom().getMinute(),
                entity.getTo().getDay().toString(), entity.getTo().getHour(), entity.getTo().getMinute(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(WorkTimeQueries.DELETE, id);
    }
}
