package by.bsuir.demo.mapper;

import by.bsuir.demo.common.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setCnum(resultSet.getString("U.CNUM"));
        user.setAddress(resultSet.getString("U.ADDRESS"));
        user.setFathername(resultSet.getString("U.FATHERNAME"));
        user.setName(resultSet.getString("U.UNAME"));
        user.setSurname(resultSet.getString("U.SURNAME"));
        user.setPhone(resultSet.getString("U.PHONE"));

        return user;
    }
}
