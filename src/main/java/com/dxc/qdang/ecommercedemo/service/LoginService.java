package com.dxc.qdang.ecommercedemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private DataSource dataSource;

    public boolean validateUser(String username, String password) {
        Boolean result = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String dbUsername;
        String dbPassword;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT username, password FROM users";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");

                result = username.equalsIgnoreCase(dbUsername) && password.equals(dbPassword);
                if (result) {
                    break;
                }
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
