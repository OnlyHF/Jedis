package com.jedis.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jedis.common.io.IOUtils;
import com.jedis.common.utils.JedisUtils;

import redis.clients.jedis.Jedis;

/**
 * Jedis使用set
 * @author qianzhubing
 *
 */
public class JedisSet {

	public static void main(String[] args) {
		Jedis jedis = new Jedis(JedisUtils.IP, JedisUtils.PORT);
		String key = "jedisSet3";
		Long result = jedis.sadd(key, "1", "2", "3");
		IOUtils.addLog("add " + key + " 1 2 3", result.toString());
		
		Set<String> smembers = jedis.smembers(key);
		List<String> listSmembers = new ArrayList<String>(smembers);
		IOUtils.addLogList("smemebers " + key, listSmembers);
		
		Long remResult = jedis.srem(key, "1", "3");
		IOUtils.addLog("srem " + key + " 1 3", remResult.toString());
		
		jedis.close();
	}
}
