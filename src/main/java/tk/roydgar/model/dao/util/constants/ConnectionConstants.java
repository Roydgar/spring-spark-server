package tk.roydgar.model.dao.util.constants;

import tk.roydgar.util.constants.FileNames;

import java.util.ResourceBundle;

public interface ConnectionConstants {

    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.DAO_CONFIG);

    String MYSQL_JDBC_DRIVER = bundle.getString("db.driver");
    String HEROKU_URL = bundle.getString("db.heroku.url");
    String HEROKU_USER = bundle.getString("db.heroku.user");
    String HEROKU_PASSWORD = bundle.getString("db.heroku.password");
    String LOCAL_URL = bundle.getString("db.local.url");
    String LOCAL_USER = bundle.getString("db.local.user");
    String LOCAL_PASSWORD = bundle.getString("db.local.password");

}
