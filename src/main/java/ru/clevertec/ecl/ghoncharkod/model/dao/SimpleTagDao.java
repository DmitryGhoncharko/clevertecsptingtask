package ru.clevertec.ecl.ghoncharkod.model.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;
import ru.clevertec.ecl.ghoncharkod.model.dao.mapper.TagMapper;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SimpleTagDao implements TagDao {
    private static final String SQL_ADD_TAG = "insert into tag(name) values(?)";
    private static final String SQL_GET_TAG_BY_ID = "select id, name from tag where id = ?";

    private static final String SQL_GET_TAG_BY_NAME = "select id, name from tag where name = ?";

    private static final String SQL_DELETE_TAG_BY_ID  = "delete from tag where id = ?";

    private static final String SQL_DELETE_TAG_BY_NAME  = "delete from tag where name = ?";

    private static final String SQL_UPDATE_TAG_BY_ID = "update tag set name = ? where id = ?";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper tagMapper;
    @Override
    public boolean add(String name) {
        return jdbcTemplate.update(SQL_ADD_TAG, name) > 0;
    }

    @Override
    public Optional<Tag> get(long id) {
       return Optional.of((Tag) jdbcTemplate.query(SQL_GET_TAG_BY_ID, new Object[]{id}, tagMapper));
    }

    @Override
    public Optional<Tag> get(String name) {
        return Optional.of((Tag) jdbcTemplate.query(SQL_GET_TAG_BY_NAME, new Object[]{name}, tagMapper));
    }

    @Override
    public boolean remove(long id)  {
       return jdbcTemplate.update(SQL_DELETE_TAG_BY_ID, id)>0;
    }

    @Override
    public boolean remove(String name) {
        return jdbcTemplate.update(SQL_DELETE_TAG_BY_NAME,name)>0;
    }

    @Override
    public boolean update(long id,String name) {
       return jdbcTemplate.update(SQL_UPDATE_TAG_BY_ID, name,id)>0;
    }
}
