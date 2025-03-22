package org.example.database.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("toy")
public class Toy {
    private int id;
    private int studentId;
    private String name;
}
