package com.demo.webfluxdatabse.service;

import com.demo.webfluxdatabse.entity.Student;
import com.demo.webfluxdatabse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Mono<Long> getAllStudents(){
        Mono<Long> count = studentRepository.findAll().count();
        return count;
    }

    public Flux<Student> findAll(){
        return  studentRepository.findAll();
    }
}
