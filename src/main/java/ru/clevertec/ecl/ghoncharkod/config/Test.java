package ru.clevertec.ecl.ghoncharkod.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.ecl.ghoncharkod.model.dao.SimpleTagDao;
import ru.clevertec.ecl.ghoncharkod.model.dao.TagDao;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TagDao tagDao = context.getBean(SimpleTagDao.class);
        tagDao.add("TEST");
    }
}
