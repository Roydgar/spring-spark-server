package tk.roydgar.model.dao.util.constants.news;

import tk.roydgar.util.constants.FileNames;

import java.util.ResourceBundle;

public interface NewsQueries {
    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.NEWS_QUERIES);

    String CREATE        = bundle.getString("create");
    String FIND_BY_ID    = bundle.getString("findById");
    String FIND_ALL      = bundle.getString("findAll");
    String UPDATE        = bundle.getString("update");
    String DELETE        = bundle.getString("delete");
    String FIND_BY_CLIENT_ID = bundle.getString("findByClientId");
}
