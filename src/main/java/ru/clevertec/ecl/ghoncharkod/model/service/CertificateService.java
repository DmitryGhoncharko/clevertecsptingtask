package ru.clevertec.ecl.ghoncharkod.model.service;

import ru.clevertec.ecl.ghoncharkod.entity.Certificate;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CertificateService {
    boolean add(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag);

    Optional<Certificate> get(Long id);

    boolean remove(Long id);

    boolean update(Long id,String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag);
}
