package tk.roydgar.model.dao.util.constants.comment;

import tk.roydgar.util.constants.FileNames;

import java.util.ResourceBundle;

public interface CommentQueries {
    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.COMMENT_QUERIES);

    String CREATE        = bundle.getString("create");
    String FIND_BY_ID    = bundle.getString("findById");
    String FIND_ALL      = bundle.getString("findAll");
    String UPDATE        = bundle.getString("update");
    String DELETE        = bundle.getString("delete");
    String FIND_BY_CLIENT_ID = bundle.getString("findByClientId");

}
