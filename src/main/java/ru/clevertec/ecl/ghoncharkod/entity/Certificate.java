package ru.clevertec.ecl.ghoncharkod.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Certificate {
    private Long id;
    private String description;
    private Double price;
    private Integer duration;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
}
