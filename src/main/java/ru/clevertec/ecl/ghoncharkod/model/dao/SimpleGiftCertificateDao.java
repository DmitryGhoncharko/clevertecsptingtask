package ru.clevertec.ecl.ghoncharkod.model.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.GiftCertificate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SimpleGiftCertificateDao implements GiftCertificateDao{
    private static final String SQL_GET_BY_TAG_NAME_SORT_BY_NAME_ASC = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where name like ?\n" +
            "order by t.name ASC";
    private static final String  SQL_GET_BY_TAG_NAME_SORT_BY_NAME_DESC = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where name like ?\n" +
            "order by t.name DESC";
    private static final String SQL_GET_BY_TAG_NAME = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where name like ?";
    private static final String SQL_GET_BY_DESCRIPTION_NAME_SORT_BY_ASC = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where gc.description like ?\n" +
            "order by name ASC ";
    private static final String SQL_GET_BY_DESCRIPTION_NAME_SORT_BY_DESC = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where gc.description like ?\n" +
            "order by name DESC ";
    private static final String SQL_GET_BY_DESCRIPTION_NAME = "select gc.id, gc.description, gc.price, gc.duration, gc.create_date, gc.last_update_date, t.id, t.name from gift_cert_tag\n" +
            "inner join gift_certificate gc on gc.id = gift_cert_tag.cert_id\n" +
            "inner join tag t on t.id = gift_cert_tag.tag_id\n" +
            "where gc.description like ?";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper mapper;
    @Override
    public List<GiftCertificate> getByTagName(String tagName, boolean sortByNameASC, boolean sortByNameDESC) {
        if(sortByNameASC){
            return jdbcTemplate.query(SQL_GET_BY_TAG_NAME_SORT_BY_NAME_ASC,new Object[]{"%"+tagName+"%"},mapper);
        }else if(sortByNameDESC){
            return jdbcTemplate.query(SQL_GET_BY_TAG_NAME_SORT_BY_NAME_DESC,new Object[]{"%"+tagName+"%"}, mapper);
        }else {
            return jdbcTemplate.query(SQL_GET_BY_TAG_NAME,new Object[]{"%"+tagName+"%"}, mapper);
        }
    }

    @Override
    public List<GiftCertificate> getByDescriptionName(String descriptionName, boolean sortByNameASC, boolean sortByNameDESC) {
        if(sortByNameASC){
            return jdbcTemplate.query(SQL_GET_BY_DESCRIPTION_NAME_SORT_BY_ASC,new Object[]{"%"+descriptionName+"%"},mapper);
        }else if(sortByNameDESC){
            return jdbcTemplate.query(SQL_GET_BY_DESCRIPTION_NAME_SORT_BY_DESC,new Object[]{"%"+descriptionName+"%"},mapper);
        }else {
            return jdbcTemplate.query(SQL_GET_BY_DESCRIPTION_NAME,new Object[]{"%"+descriptionName+"%"},mapper);
        }
    }
}
