package com.gift.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

    private static JdbcTemplate jdbcTemplate;
    private static final String SELECT_ALL = "SELECT * FROM USER_DETAILS";


    public UserDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserDetails> getAllUserDetails() {
        long start = System.currentTimeMillis();
        LOGGER.info("Going to retrieve User Details list");
        List<UserDetails> userDetailsList = jdbcTemplate.query(SELECT_ALL, new RowMapper<UserDetails>() {

        public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDetails userDetails = new UserDetails();
            userDetails.setUserName(rs.getString("USERNAME"));
            userDetails.setUserId(rs.getString("USER_ID"));
            userDetails.setAddress(rs.getString("ADDRESS"));
            userDetails.setCountry(rs.getString("COUNTRY"));

            return userDetails;
            }
        });

        LOGGER.info(String.format("Retrieved %s User Detail(s) in %s ms", userDetailsList.size(), System.currentTimeMillis() - start));


        return userDetailsList;
    }
}
