package ru.clevertec.ecl.ghoncharkod.validator;

import org.springframework.stereotype.Component;

@Component
public class SimpleTagValidator implements TagValidator{
    @Override
    public boolean validate(String name) {
        return name!=null && name.length()<=500;
    }
}
