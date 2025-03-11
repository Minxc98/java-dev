package com.example.databaseredisbase;

import org.junit.jupiter.api.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseRedisBaseApplicationTests {

	@Autowired
	private RedissonClient redissonClient;

	@Test
	void contextLoads() {
		redissonClient.getBucket("test").set("test");
		System.out.println(redissonClient.getBucket("test").get());
	}

	@Test
	void test() {
		RAtomicLong asdfasd = redissonClient.getAtomicLong("asdfasd");
		asdfasd.set(Long.MAX_VALUE);
		long l = asdfasd.incrementAndGet();
		System.out.println(l);
	}

}
