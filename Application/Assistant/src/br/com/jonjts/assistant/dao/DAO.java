/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class DAO {

    private ConnectionSource connectionSource;
    private static DAO instance;
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/assistant";

    private DAO() {
        try {
            connectionSource = createConnectionSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ConnectionSource createConnectionSource() throws SQLException {
        return new JdbcConnectionSource(databaseUrl, "root", "jonas");
    }

    public static DAO instance() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }
}
