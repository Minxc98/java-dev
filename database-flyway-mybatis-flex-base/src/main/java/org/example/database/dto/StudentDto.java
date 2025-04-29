package org.example.database.dto;

import lombok.Data;
import org.example.database.entity.Toy;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String name;
    private int age;
    private List<Toy> toys;
}
