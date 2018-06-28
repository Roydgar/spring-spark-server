package tk.roydgar.model.dao.util.constants.mapper;

import org.springframework.jdbc.core.RowMapper;
import tk.roydgar.model.dao.util.constants.client.ClientColumnNames;
import tk.roydgar.model.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        int id          = rs.getInt(ClientColumnNames.ID);
        String login    = rs.getString(ClientColumnNames.LOGIN);
        String password = rs.getString(ClientColumnNames.PASSWORD);
        String name     = rs.getString(ClientColumnNames.NAME);
        String phone    = rs.getString(ClientColumnNames.PHONE);
        String email    = rs.getString(ClientColumnNames.EMAIL);
        String address  = rs.getString(ClientColumnNames.ADDRESS);
        LocalDateTime date = rs.getTimestamp(
                ClientColumnNames.REGISTRATION_DATE).toLocalDateTime();

        return Client.builder().id(id).login(login)
                .password(password).name(name).phone(phone)
                .registrationDate(date).email(email).address(address).build();
    }

}
