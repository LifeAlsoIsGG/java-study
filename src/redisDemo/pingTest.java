package redisDemo;

import redis.clients.jedis.Jedis;

/**
 * @Project: Java-Study
 * @Package: redisDemo
 * @ClassName: pingTest
 * @Author: Chen Long
 * @Description: pingTest
 * @Datetime: 2020/11/29  16:30
 */
public class pingTest {
    
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.100.59.153", 6379);
        jedis.auth("0.00.0");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("demo"));
    }
}
