package org.example.database.service;

import org.example.database.dao.StudentMapper;
import org.example.database.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(int id) {
        studentMapper.deleteById(id);
    }

    public void deleteStudentById(int id) {
        transactionTemplate.executeWithoutResult(status -> {
            try{

                studentMapper.deleteById(id);
            }catch (Exception e){
                status.setRollbackOnly();
                throw e;
            }
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentDto deleteStudentWrong(int id) {
        studentMapper.deleteById(id);
        int i = 1 / 0;
        return null;
    }



    public StudentDto deleteStudentByIdWrong(int id) {
        transactionTemplate.executeWithoutResult(status -> {
            try{
                studentMapper.deleteById(id);
                int i = 1 / 0;
            }catch (Exception e){
                status.setRollbackOnly();
                throw e;
            }
        });
        return null;
    }

}
