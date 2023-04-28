package ru.clevertec.ecl.ghoncharkod.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Tag {
    private Long id;
    private String name;
}
