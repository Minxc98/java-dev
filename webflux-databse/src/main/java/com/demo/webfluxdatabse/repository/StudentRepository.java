package com.demo.webfluxdatabse.repository;

import com.demo.webfluxdatabse.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student,Long> {

}