package tk.roydgar.model.dao.util.constants.client;

import org.springframework.context.annotation.PropertySource;
import tk.roydgar.util.constants.FileNames;

import javax.annotation.Resource;
import java.util.ResourceBundle;

public interface ClientQueries {

    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.CLIENT_QUERIES);

    String LOGIN         = bundle.getString("login");
    String CREATE        = bundle.getString("create");
    String FIND_BY_ID    = bundle.getString("findById");
    String FIND_ALL      = bundle.getString("findAll");
    String UPDATE        = bundle.getString("update");
    String DELETE        = bundle.getString("delete");
    String FIND_BY_LOGIN = bundle.getString("findByLogin");

    String CREATE_TABLE  = bundle.getString("create.table");
    String DROP_TABLE    = bundle.getString("drop.table");
    String TRUNCATE_TABLE= bundle.getString("truncate.table");

}
