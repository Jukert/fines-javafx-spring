package by.bsuir.demo.dao.impl;

import by.bsuir.demo.common.Car;
import by.bsuir.demo.dao.CarDao;
import by.bsuir.demo.mapper.CarMapper;
import by.iba.sql.builder.impls.UpdateBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDaoImpl implements CarDao {

    private JdbcDaoTemplate jdbcDaoTemplate;

    public CarDaoImpl(JdbcDaoTemplate jdbcDaoTemplate) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;
    }

    @Override
    public void save(Car car) {

        Map<String, Object> paramMap = new HashMap<>();

        String sql = new UpdateBuilder(paramMap)
                .sql("INSERT " +
                        "INTO " +
                        "    `fines`.`cars` " +
                        "    (" +
                        "        `MARK`, " +
                        "        `COLOR`, " +
                        "        `GOS_NUMBER`, " +
                        "        `CNUM`, " +
                        "        `WEIGHT`, " +
                        "        `MAX_SPEED` " +
                        "    ) " +
                        "    VALUES ")
                .insert("mark", car.getMark())
                .insert("color", car.getColor())
                .insert("number", car.getGovernmentNumber())
                .insert("cnum", car.getUser().getCnum())
                .insert("weight", car.getWeight())
                .insert("speed", car.getMaxSpeed())
                .build();

        jdbcDaoTemplate.update(sql, paramMap);
    }

    @Override
    public List<Car> findAll() {
        String sql = "SELECT " +
                "    C.ID, " +
                "    C.MARK, " +
                "    C.COLOR, " +
                "    C.GOS_NUMBER, " +
                "    C.CNUM, " +
                "    C.WEIGHT, " +
                "    C.MAX_SPEED," +
                "    U.CNUM," +
                "    U.SURNAME," +
                "    U.UNAME," +
                "    U.FATHERNAME," +
                "    U.ADDRESS," +
                "    U.PHONE " +
                "FROM " +
                "    fines.cars C " +
                "INNER JOIN " +
                "    fines.user U " +
                "ON U.CNUM = C.CNUM ";

        return jdbcDaoTemplate.query(sql, new CarMapper());
    }
}
