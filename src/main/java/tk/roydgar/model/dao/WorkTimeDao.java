package tk.roydgar.model.dao;

import tk.roydgar.model.entity.workTime.WorkTime;

import java.util.List;

public interface WorkTimeDao extends GenericDao<WorkTime> {

    List<WorkTime> findByClientId(int clientId);
    void create(WorkTime workTime, int clientId);

}

