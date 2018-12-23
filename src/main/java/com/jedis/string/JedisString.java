package com.jedis.string;

import redis.clients.jedis.Jedis;

/**
 * jedis 字符类型
 * @author qianzhubing
 *
 */
public class JedisString {

	private static String host = "192.168.170.145";
	private static int port = 6379;
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis(host, port);
//		System.out.println(jedis.isConnected());
//		jedis.connect();
//		jedis.set("hello", "world");
		String getHello = jedis.get("hello");
		System.out.println("get hello ---> " + getHello);
		System.out.println(jedis.incr("mynum"));
		jedis.close();
//		System.out.println(jedis.isConnected());
//		jedis.disconnect();
	}
}
