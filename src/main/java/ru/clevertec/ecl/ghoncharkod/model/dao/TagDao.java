package ru.clevertec.ecl.ghoncharkod.model.dao;

import ru.clevertec.ecl.ghoncharkod.entity.Tag;

import java.util.Optional;

public interface TagDao {
    boolean add(String name);

    Optional<Tag> get(long id);

    Optional<Tag> get(String name);

    boolean remove(long id);

    boolean remove(String name);

    boolean update(long id, String name);

}
