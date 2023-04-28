package ru.clevertec.ecl.ghoncharkod.validator;

import ru.clevertec.ecl.ghoncharkod.entity.Tag;

import java.time.LocalDateTime;

public interface CertificateValidator {
    boolean validate(Long id, String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime);
    boolean validate(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag);

    boolean validate(Long id);
}
