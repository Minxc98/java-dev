package com.demo.webfluxdatabse.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("student")
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer age;
}
