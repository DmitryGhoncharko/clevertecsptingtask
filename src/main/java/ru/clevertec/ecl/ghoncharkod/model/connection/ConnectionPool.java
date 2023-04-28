package ru.clevertec.ecl.ghoncharkod.model.connection;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {

    DataSource getDataSource();
}