package tk.roydgar.model.dao.util.constants;

import tk.roydgar.util.constants.FileNames;

import java.util.ResourceBundle;

public interface GeneralQueries {

    ResourceBundle bundle = ResourceBundle.getBundle(FileNames.GENERAL_QUERIES);

    String DISABLE_FOREIGN_KEY_CHECK = bundle.getString("disableForeignKeyCheck");
    String ENABLE_FOREIGN_KEY_CHECK = bundle.getString("enableForeignKeyCheck");

}
