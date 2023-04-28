package ru.clevertec.ecl.ghoncharkod.model.dao;

import ru.clevertec.ecl.ghoncharkod.entity.Certificate;

import java.time.LocalDateTime;

public interface CertificateTagDao {
    boolean add(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime);

    Certificate get(Long id);

    boolean remove(Long id);

    boolean update(Long id,String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime);
}
