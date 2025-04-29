package org.example.database.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.database.dto.StudentDto;
import org.example.database.entity.Student;

import java.util.List;

public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id=#{id} LIMIT 1")
    Student userById(Integer id);

    Student findBookById(int id);

    @Select("SELECT * FROM student WHERE name=#{name} LIMIT 1")
    List<Student> selectList(String name);

    List<StudentDto> getAllStudents();

    void deleteById(@Param("id")int id);

}