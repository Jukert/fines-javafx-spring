package by.bsuir.demo.mapper;

import by.bsuir.demo.common.BorderSpeed;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorderSpeedMapper implements RowMapper<BorderSpeed> {

    public BorderSpeed mapRow(ResultSet resultSet, int i) throws SQLException {
        BorderSpeed borderSpeed = new BorderSpeed();

        borderSpeed.setId(resultSet.getInt("BS.ID"));
        borderSpeed.setMax(resultSet.getInt("BS.MAX"));
        borderSpeed.setMin(resultSet.getInt("BS.MIN"));
        borderSpeed.setDescription(resultSet.getString("BS.DESCRIPTION"));

        return borderSpeed;
    }
}
