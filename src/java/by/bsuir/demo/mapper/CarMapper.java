package by.bsuir.demo.mapper;

import by.bsuir.demo.common.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("C.ID"));
        car.setColor(resultSet.getString("C.COLOR"));
        car.setGovernmentNumber(resultSet.getString("C.GOS_NUMBER"));
        car.setMark(resultSet.getString("C.MARK"));
        car.setMaxSpeed(resultSet.getString("C.MAX_SPEED"));
        car.setWeight(resultSet.getInt("C.WEIGHT"));
        car.setUser(new UserMapper().mapRow(resultSet, i));
        return car;
    }

}
