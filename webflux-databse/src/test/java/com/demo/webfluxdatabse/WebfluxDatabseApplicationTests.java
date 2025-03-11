package com.demo.webfluxdatabse;

import com.demo.webfluxdatabse.repository.StudentRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebfluxDatabseApplicationTests {

	@Resource
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
		//添加数据
		studentRepository.findAll().subscribe(System.out::println);
	}

}
