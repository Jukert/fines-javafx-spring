package by.bsuir.demo.dao.impl;

import by.bsuir.demo.common.Fine;
import by.bsuir.demo.dao.FineDao;
import by.bsuir.demo.filter.FineFilter;
import by.bsuir.demo.mapper.FineMapper;
import by.iba.sql.factory.SqlBuilderFactory;
import by.iba.sql.util.SqlConstatnt;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FineDaoImpl implements FineDao {

    private JdbcDaoTemplate jdbcDaoTemplate;

    private SqlBuilderFactory sqlBuilderFactory;

    public FineDaoImpl(JdbcDaoTemplate jdbcDaoTemplate, SqlBuilderFactory sqlBuilderFactory) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;
        this.sqlBuilderFactory = sqlBuilderFactory;
    }

    public void save(Fine fine) {

        String sql = "";

    }

    public List<Fine> findAll(FineFilter filter) {

        Map<String, Object> paramMap = new HashMap<>();
        String sql = null;
        try {
            sql = sqlBuilderFactory.newSqlBuilder(paramMap)
                    .sql("SELECT DISTINCT " +
                            "    F.ID, " +
                            "    F.CNUM, " +
                            "    F.LOCATION_ID, "  +
                            "    F.BORDER_SPEED_ID, " +
                            "    F.CAR_ID, " +
                            "    U.CNUM, " +
                            "    U.SURNAME, " +
                            "    U.UNAME, " +
                            "    U.FATHERNAME, " +
                            "    U.ADDRESS, " +
                            "    U.PHONE, " +
                            "    C.ID, " +
                            "    C.MARK, " +
                            "    C.COLOR, " +
                            "    C.GOS_NUMBER, " +
                            "    C.CNUM, " +
                            "    C.WEIGHT, " +
                            "    C.MAX_SPEED, " +
                            "    L.ID, " +
                            "    L.REGION, " +
                            "    BS.ID, " +
                            "    BS.MIN, " +
                            "    BS.MAX," +
                            "    BS.DESCRIPTION " +
                            "FROM " +
                            "    fines.fine F " +
                            "INNER JOIN " +
                            "    fines.user U " +
                            "ON " +
                            "    U.CNUM = F.CNUM " +
                            "INNER JOIN " +
                            "    fines.cars C " +
                            "ON " +
                            "    C.ID = F.CAR_ID " +
                            "INNER JOIN " +
                            "    fines.location L " +
                            "ON " +
                            "    L.ID = F.LOCATION_ID " +
                            "INNER JOIN " +
                            "    fines.border_speed BS " +
                            "ON " +
                            "    BS.ID = F.BORDER_SPEED_ID " +
                            " WHERE ")
                    .like().expression(filter.getSurname() != null).column("U.SURNAME").value(filter.getSurname()).end()
                    .and()
                    .like().expression(filter.getName() != null).column("U.UNAME").value(filter.getName()).end()
                    .and()
                    .like().expression(filter.getFathername() != null).column("U.FATHERNAME").value(filter.getFathername()).end()
                    .and()
                    .compare().expression(filter.getGovernmentNumber() != null).column("C.GOS_NUMBER").operator(SqlConstatnt.EQUALS).value(filter.getGovernmentNumber()).end()
                    .and()
                    .compare().expression(filter.getCnum() != null).operator(SqlConstatnt.EQUALS).column("U.CNUM").value(filter.getCnum()).end()
                    .build();
        } catch (SQLSyntaxErrorException e) {
            throw new RuntimeException("Build sql was failed");
        }

        List<Fine> fines = jdbcDaoTemplate.query(sql, paramMap, new FineMapper());

        return fines;
    }

}
