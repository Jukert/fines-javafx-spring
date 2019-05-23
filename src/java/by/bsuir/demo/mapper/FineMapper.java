package by.bsuir.demo.mapper;

import by.bsuir.demo.common.Fine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FineMapper implements RowMapper<Fine> {

    public Fine mapRow(ResultSet resultSet, int i) throws SQLException {
        Fine fine = new Fine();

        fine.setId(resultSet.getInt("F.ID"));
        fine.setBorderSpeed(new BorderSpeedMapper().mapRow(resultSet, i));
        fine.setCar(new CarMapper().mapRow(resultSet, i));
        fine.setLocation(new LocationMapper().mapRow(resultSet, i));
        fine.setUser(new UserMapper().mapRow(resultSet, i));
        fine.setSpeed(resultSet.getInt("SPEED"));

        return fine;
    }
}
