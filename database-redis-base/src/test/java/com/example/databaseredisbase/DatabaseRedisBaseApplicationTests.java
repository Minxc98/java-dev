package com.example.databaseredisbase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class DatabaseRedisBaseApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;



	public void setWithExpire(String key, Object value, long expire, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, expire, unit);
	}

	public Boolean setIfAbsentWithExpire(String key, String value, long ttl, TimeUnit unit) {
		Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, ttl, unit);
		return result != null ? result : false;
	}


	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("name", "张三");
		Assert.isTrue("张三".equals(redisTemplate.opsForValue().get("name")), "名字不对");
		//delete
		redisTemplate.delete("name");
		Assert.isNull(redisTemplate.opsForValue().get("name"), "名字不对");
	}

	@Test
	void testNx(){
		Boolean b = setIfAbsentWithExpire("name", "张三", 2, TimeUnit.MINUTES);
		Assert.isTrue(b, "名字不对");
		Boolean b2 = setIfAbsentWithExpire("name", "张三", 2, TimeUnit.MINUTES);
		Assert.isTrue(!b2, "名字不对");
		//delete
		redisTemplate.delete("name");
	}

}
