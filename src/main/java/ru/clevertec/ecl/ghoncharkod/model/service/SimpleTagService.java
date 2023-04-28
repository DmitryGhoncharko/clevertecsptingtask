package ru.clevertec.ecl.ghoncharkod.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.ghoncharkod.entity.Tag;
import ru.clevertec.ecl.ghoncharkod.model.dao.TagDao;
import ru.clevertec.ecl.ghoncharkod.validator.TagValidator;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleTagService implements TagService {
    private final TagDao tagDao;
    private final TagValidator tagValidator;

    @Override
    public boolean add(String name) {
        if (tagValidator.validate(name)) {
            return tagDao.add(name);
        }
        return false;
    }

    @Override
    public Optional<Tag> get(long id) {
        return tagDao.get(id);
    }

    @Override
    public Optional<Tag> get(String name) {
        if (tagValidator.validate(name)) {
            return tagDao.get(name);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(long id) {
        return tagDao.remove(id);
    }

    @Override
    public boolean remove(String name) {
        return tagDao.remove(name);
    }

    @Override
    public boolean update(long id, String name) {
        if (tagValidator.validate(name)) {
            return tagDao.update(id, name);
        }
        return false;
    }
}
