package com.jedis.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.jedis.common.utils.DateUtils;
import com.jedis.common.utils.JedisUtils;

import redis.clients.jedis.Jedis;

public class JedisHash {

	public static void main(String[] args) {
		Jedis jedis = new Jedis(JedisUtils.IP, JedisUtils.PORT);
		Map<String, String> hash = new HashMap<>();
		hash.put("name", "zhangsan");
		hash.put("sex", "male");
		hash.put("age", "24");
		String key = "hash" + DateUtils.getFormatDate();
		jedis.hset(key, hash);
		System.out.println("jedies>>> hset 完成， key值为：" + key);
		
		Map<String, String> getKeyMap = jedis.hgetAll(key);
		Set<Entry<String, String>> keySets = getKeyMap.entrySet();
		for(Entry<String, String> e : keySets) {
			System.out.println(key + " --> " + e.getKey() + " --> " + e.getValue());
		}
		
		boolean hexists = jedis.hexists(key, "name");
		System.out.println("hexists " + key + " name : " + hexists);
		
		jedis.close();
	}
}
