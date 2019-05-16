package by.bsuir.demo.dao.impl;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class JdbcDaoTemplate extends JdbcDaoSupport {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcDaoTemplate(DataSource dataSource) {
        setDataSource(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public <T> List<T> query(String sql, Map<String, Object> paramMap, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(sql, paramMap, rowMapper);
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(sql, rowMapper);
    }

    public <T> T query(String sql, Map<String, Object> paramMap, ResultSetExtractor<T> rowMapper) {
        return namedParameterJdbcTemplate.query(sql, paramMap, rowMapper);
    }

    public void batchUpdate(String sql, SqlParameterSource[] batchArgs) {
        namedParameterJdbcTemplate.batchUpdate(sql, batchArgs);
    }

    public void update(String sql, Map<String, Object> paramMap) {
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    public void update(String sql, SqlParameterSource sqlParameterSource, KeyHolder key) {
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, key);
    }

    public int total(String sql, Map<String, Object> paramMap, Class<?> clazz) {
        return (Integer) namedParameterJdbcTemplate.queryForObject(sql, paramMap, clazz);
    }
}
