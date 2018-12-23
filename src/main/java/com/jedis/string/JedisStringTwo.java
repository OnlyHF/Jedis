package com.jedis.string;

import com.jedis.common.utils.JedisUtils;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author qianzhubing
 *
 */
public class JedisStringTwo {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis(JedisUtils.IP, JedisUtils.PORT);
		long postId = jedis.incr("num");
		String name = "post."+postId+".data";
		String value = postId + ",hello" + ",world";
		
		jedis.set(name, value);	
		System.out.println(name);
		
		value = jedis.get(name);
		String[] vals = value.split(",");
		for (String s : vals) {
			System.out.println(s);
		}
		jedis.close();
	}
}
