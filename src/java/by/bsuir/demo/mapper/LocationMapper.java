package by.bsuir.demo.mapper;

import by.bsuir.demo.common.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {

    public Location mapRow(ResultSet resultSet, int i) throws SQLException {

        Location location = new Location();
        location.setId(resultSet.getInt("L.ID"));
        location.setRegion(resultSet.getString("L.REGION"));

        return location;
    }
}
