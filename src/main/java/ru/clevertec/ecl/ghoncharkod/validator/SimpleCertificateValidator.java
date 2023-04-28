package ru.clevertec.ecl.ghoncharkod.validator;

import org.springframework.stereotype.Component;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;

import java.time.LocalDateTime;

@Component
public class SimpleCertificateValidator implements CertificateValidator{
    @Override
    public boolean validate(Long id, String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime) {
        return id!=null && description!=null && price!=null && dateCreate!=null && lastUpdateTime!=null && description.length()<=1000;
    }

    @Override
    public boolean validate(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag) {
        return description!=null && price!=null && dateCreate!=null && lastUpdateTime!=null && description.length()<=1000 && tag!=null && tag.getId()!=null && tag.getName()!=null;
    }

    @Override
    public boolean validate(Long id) {
        return id!=null;
    }
}
