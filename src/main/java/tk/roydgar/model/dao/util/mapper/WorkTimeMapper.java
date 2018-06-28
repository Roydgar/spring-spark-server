package tk.roydgar.model.dao.util.mapper;

import org.springframework.jdbc.core.RowMapper;
import tk.roydgar.model.dao.util.constants.workTime.WorkTimeColumnNames;
import tk.roydgar.model.entity.workTime.Day;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;

public class WorkTimeMapper implements RowMapper<WorkTime> {

    @Override
    public WorkTime mapRow(ResultSet rs, int i) throws SQLException {
        int id            = rs.getInt(WorkTimeColumnNames.ID);
        DayOfWeek fromDay = DayOfWeek.valueOf(rs.getString(WorkTimeColumnNames.FROM_DAY));
        String fromHour = rs.getString(WorkTimeColumnNames.FROM_HOUR);
        String fromMin  = rs.getString(WorkTimeColumnNames.FROM_MIN);
        DayOfWeek toDay = DayOfWeek.valueOf(rs.getString(WorkTimeColumnNames.TO_DAY));
        String toHour   = rs.getString(WorkTimeColumnNames.TO_HOUR);
        String toMin    = rs.getString(WorkTimeColumnNames.TO_MIN);

        return new WorkTime(id, Day.builder().day(fromDay).hour(fromHour).minute(fromMin).build(),
                Day.builder().day(toDay).hour(toHour).minute(toMin).build());
    }

}
