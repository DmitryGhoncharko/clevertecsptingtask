package ru.clevertec.ecl.ghoncharkod.model.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Certificate;
import ru.clevertec.ecl.ghoncharkod.entity.GiftCertificate;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class GiftCertificateMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return GiftCertificate.builder().
                certificate(Certificate.builder().
                        id(rs.getLong("gc.id")).
                        description(rs.getString("gc.description")).
                        price(rs.getDouble("gc.price")).
                        duration(rs.getInt("gc.duration")).
                        createDate(rs.getTimestamp("gc.create_date").toLocalDateTime()).
                        lastUpdateDate(rs.getTimestamp("gc.last_update_date").toLocalDateTime()).
                        build()).
                tag(Tag.builder().
                        id(rs.getLong("t.id")).
                        name("t.name").
                        build()).
                build();
    }
}
