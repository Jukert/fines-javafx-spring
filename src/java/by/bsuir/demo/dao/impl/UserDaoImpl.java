package by.bsuir.demo.dao.impl;

import by.bsuir.demo.common.User;
import by.bsuir.demo.dao.UserDao;
import by.bsuir.demo.mapper.UserMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcDaoTemplate jdbcDaoTemplate;

    public UserDaoImpl(JdbcDaoTemplate jdbcDaoTemplate) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;
    }

    @Override
    public List<User> findAll() {

        String sql =
                "SELECT " +
                    "    U.CNUM," +
                    "    U.SURNAME," +
                    "    U.UNAME," +
                    "    U.FATHERNAME," +
                    "    U.ADDRESS," +
                    "    U.PHONE " +
                    "FROM " +
                    "    fines.user U ";

        return jdbcDaoTemplate.query(sql, new UserMapper());

    }
}
