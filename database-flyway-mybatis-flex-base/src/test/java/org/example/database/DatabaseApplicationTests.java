package org.example.database;

import org.example.database.dao.StudentMapper;
import org.example.database.entity.Student;
import org.example.database.service.StudentService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;

import static org.junit.Assert.assertThrows;

@SpringBootTest
class DatabaseApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DataSource dataSource;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void testConnection() throws IOException {
        Student student = studentMapper.userById(null);
        System.out.println(student.getName());
    }

    @Test
    void testResultMap() {


    }


    @Test
    void testDeleteData() {
        assertThrows(ArithmeticException.class, () -> {
            studentService.deleteStudentWrong(1);
            int i = 1 / 0;
        });
        org. junit. Assert.assertTrue(studentMapper.getAllStudents().size() == 3);
    }


    @Test
    void testDeleteDataManual() {
        assertThrows(ArithmeticException.class, () -> {
            studentService.deleteStudentById(1);
            int i = 1 / 0;
        });
        org. junit. Assert.assertTrue(studentMapper.getAllStudents().size() != 3);
    }



    @Test
    void testRollbackAutoCommit() {
        assertThrows(ArithmeticException.class, () -> {
            studentService.deleteStudentWrong(1);
        });
        org. junit. Assert.assertTrue(studentMapper.getAllStudents().size() == 3);
    }

    @Test
    void testRollbackManualCommit() {
        assertThrows(ArithmeticException.class, () -> {
            studentService.deleteStudentByIdWrong(1);
        });
        org. junit. Assert.assertTrue(studentMapper.getAllStudents().size() == 3);
    }

}
