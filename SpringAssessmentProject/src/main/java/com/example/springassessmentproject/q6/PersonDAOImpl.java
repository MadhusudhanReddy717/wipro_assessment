package com.example.springassessmentproject.q6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        String sql = "INSERT INTO person VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.getId(), person.getAge(), person.getFirstName(), person.getLastName());
    }

    public void update(Person person) {
        String sql = "UPDATE person SET age = ?, firstName = ?, lastName = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getAge(), person.getFirstName(), person.getLastName(), person.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Person getById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonRowMapper());
    }

    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(
                rs.getInt("id"),
                rs.getInt("age"),
                rs.getString("firstName"),
                rs.getString("lastName")
            );
        }
    }
}
