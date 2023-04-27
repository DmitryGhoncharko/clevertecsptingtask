package ru.clevertec.ecl.ghoncharkod.model.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {

    Connection getConnection() throws SQLException;
}