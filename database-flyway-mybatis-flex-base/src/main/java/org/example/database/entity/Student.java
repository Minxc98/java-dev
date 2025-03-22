package org.example.database.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("student")
public class Student {
    private int id;
    private String name;
    private int age;
}
