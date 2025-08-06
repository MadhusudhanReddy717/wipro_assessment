package com.example.springassessmentproject.q7;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProductDetails(int product_code) {
        String query = "SELECT * FROM product WHERE product_code = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{product_code}, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product p = new Product();
                p.setProduct_code(rs.getInt("product_code"));
                p.setProduct_name(rs.getString("product_name"));
                p.setProduct_category(rs.getString("product_category"));
                p.setProduct_description(rs.getString("product_description"));
                p.setProduct_price(rs.getDouble("product_price"));
                return p;
            }
        });
    }
}
