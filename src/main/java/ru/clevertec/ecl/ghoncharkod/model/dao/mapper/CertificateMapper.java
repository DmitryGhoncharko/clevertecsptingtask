package ru.clevertec.ecl.ghoncharkod.model.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Certificate;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CertificateMapper implements RowMapper<Certificate> {
    @Override
    public Certificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Certificate.builder().id(rs.getLong("id")).
                description(rs.getString("description")).
                price(rs.getDouble("price")).
                duration(rs.getInt("duration")).
                createDate(rs.getTimestamp("create_date").toLocalDateTime()).
                lastUpdateDate(rs.getTimestamp("last_update_date").toLocalDateTime()).
                build();
    }
}
