package ru.clevertec.ecl.ghoncharkod.model.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Certificate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SimpleCertificateDao implements CertificateTagDao {

    private static final String SQL_ADD_CERTIFICATE = "insert into gift_certificate(description,price,duration,create_date,last_update_date) values(?,?,?,?,?)";
    private static final String SQL_GET_CERTIFICATE = "select id, description, price, duration, create_date, last_update_date from gift_certificate where id = ?";

    private static final String SQL_REMOVE_CERTIFICATE = "delete from gift_certificate where id = ?";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper certificateMapper;

    @Override
    public boolean add(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime) {
        return jdbcTemplate.update(SQL_ADD_CERTIFICATE, description, price, duration, dateCreate, lastUpdateTime) > 0;
    }

    @Override
    public Certificate get(Long id) {
        return (Certificate) jdbcTemplate.query(SQL_GET_CERTIFICATE, new Object[]{id}, certificateMapper);
    }

    @Override
    public boolean remove(Long id) {
        return jdbcTemplate.update(SQL_REMOVE_CERTIFICATE, id) > 0;
    }

    @Override
    public boolean update(Long id, String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime) {

        return jdbcTemplate.update(generateSQLForUpdateCert(id, description, price, duration, dateCreate, lastUpdateTime),id)>0;
    }

    private String generateSQLForUpdateCert(Long id, String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime) {
        StringBuilder sqlBuilder = new StringBuilder("update gift_certificate set");

        if (description != null) {
            sqlBuilder.append(" description = ").append(description).append(",");

        }
        if (price != null) {
            sqlBuilder.append(" price = ").append(price).append(",");

        }
        if (duration != null) {
            sqlBuilder.append(" duration = ").append(duration).append(",");

        }
        if (dateCreate != null) {
            sqlBuilder.append(" create_date = ").append(dateCreate).append(",");

        }
        if (lastUpdateTime != null) {
            sqlBuilder.append(" last_update_date = ").append(lastUpdateTime).append(",");

        }

        sqlBuilder.setLength(sqlBuilder.length() - 1);
        sqlBuilder.append(" WHERE id = ").append(id);

        return sqlBuilder.toString();
    }
}
