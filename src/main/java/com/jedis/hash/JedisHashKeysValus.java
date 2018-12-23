package com.jedis.hash;

import java.util.List;
import java.util.Set;

import com.jedis.common.utils.JedisUtils;

import redis.clients.jedis.Jedis;

/**
 * hkeys	获取全key值
 * hvalues	获取全value值
 * @author qianzhubing
 *
 */
public class JedisHashKeysValus {

	public static void main(String[] args) {
		Jedis jedis = new Jedis(JedisUtils.IP, JedisUtils.PORT);
		String hkey = "hash20181203122547";
		Set<String> keys = jedis.hkeys(hkey);
		List<String> values = jedis.hvals(hkey);
		
		System.out.println("hkeys " + hkey);
		for(String key : keys) {
			System.out.println(">>> " + key);
		}
		
		System.out.println("hvals " + hkey);
		for (String value : values) {
			System.out.println(">>> " + value);
		}
		
		long hlen = jedis.hlen(hkey);
		System.out.println("hlen " + hkey);
		System.out.println(">>> " + hlen);
		jedis.close();
	}
}
