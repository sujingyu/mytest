package redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("47.106.94.250");
		System.out.println(jedis.get("backup1"));
	}
}
