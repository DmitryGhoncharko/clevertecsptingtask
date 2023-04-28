package ru.clevertec.ecl.ghoncharkod.model.dao;


import ru.clevertec.ecl.ghoncharkod.entity.GiftCertificate;

import java.util.List;

public interface GiftCertificateDao {
    List<GiftCertificate> getByTagName(String tagName, boolean sortByNameASC, boolean sortByNameDESC);

    List<GiftCertificate> getByDescriptionName(String descriptionName, boolean sortByNameASC, boolean sortByNameDESC);

}
