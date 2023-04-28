package ru.clevertec.ecl.ghoncharkod.model.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TagMapper implements RowMapper<Tag> {
    @Override
    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Tag.builder().
                id(rs.getLong("id")).
                name(rs.getString("name")).
                build();
    }
}
