package ru.clevertec.ecl.ghoncharkod.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.ecl.ghoncharkod.entity.Certificate;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;
import ru.clevertec.ecl.ghoncharkod.model.dao.CertificateTagDao;
import ru.clevertec.ecl.ghoncharkod.model.dao.TagDao;
import ru.clevertec.ecl.ghoncharkod.validator.CertificateValidator;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleCertificateService implements CertificateService{
    private final CertificateTagDao certificateTagDao;
    private final TagDao tagDao;
    private final CertificateValidator certificateValidator;
    @Override
    @Transactional
    public boolean add(String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag) {
        if(certificateValidator.validate(description, price, duration, dateCreate, lastUpdateTime,tag)){
           Optional<Tag> tagFromDB = tagDao.get(tag.getName());
           if(tagFromDB.isPresent()){
               Tag tagFromOptional = tagFromDB.get();

           }
           return certificateTagDao.add(description, price, duration, dateCreate, lastUpdateTime);
        }
        return false;
    }

    @Override
    public Optional<Certificate> get(Long id) {
        if(certificateValidator.validate(id)){
            return Optional.of(certificateTagDao.get(id));
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(Long id) {
       if(certificateValidator.validate(id)){
           return certificateTagDao.remove(id);
       }
       return false;
    }

    @Override
    public boolean update(Long id, String description, Double price, Integer duration, LocalDateTime dateCreate, LocalDateTime lastUpdateTime, Tag tag) {
       if(certificateValidator.validate(id, description, price, duration, dateCreate, lastUpdateTime)){
           return certificateTagDao.update(id, description, price, duration, dateCreate, lastUpdateTime);
       }
       return false;
    }
}
