package com.rv.repositories.bd;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Database {
    Connection getConnection();
    void disconnect(Connection connection);
    ResultSet executeQuery(String query);
    int executeUpdate(String query);

}
