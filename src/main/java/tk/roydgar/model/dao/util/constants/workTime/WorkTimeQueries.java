package tk.roydgar.model.dao.util.constants.workTime;

import tk.roydgar.util.constants.FileNames;

import java.util.ResourceBundle;

public interface WorkTimeQueries {
    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.WORK_TIME_QUERIES);

    String CREATE        = bundle.getString("create");
    String FIND_BY_ID    = bundle.getString("findById");
    String FIND_ALL      = bundle.getString("findAll");
    String UPDATE        = bundle.getString("update");
    String DELETE        = bundle.getString("delete");
    String FIND_BY_CLIENT_ID = bundle.getString("findByClientId");

    String CREATE_TABLE  = bundle.getString("create.table");
    String DROP_TABLE    = bundle.getString("drop.table");
    String TRUNCATE_TABLE= bundle.getString("truncate.table");

}
