package com.jedis.list;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jedis.common.io.IOUtils;
import com.jedis.common.utils.JedisUtils;

import redis.clients.jedis.Jedis;

/**
 * redis 链表结构
 * @author qianzhubing
 *
 */
public class JedisList {

	public static void main(String[] args) {
		Jedis jedis = new Jedis(JedisUtils.IP, JedisUtils.PORT);
		String key = "JedisList";
		
//		jedis.lpush(key, "1", "2", "3");
//		jedis.rpush(key, "a", "b", "c");
//		
//		System.out.println(">>> lpush 1 2 3");
//		System.out.println(">>> rpush a b c");
//		
//		List<String> lrange = jedis.lrange(key, 0, -1);
//		
//		System.out.println(">>> " + StringUtils.join(lrange, ","));
//		
//		IOUtils.addLog("lpush JedisList 1 2 3", StringUtils.join(lrange, ","));
		
//		String lpop = jedis.lpop(key);
//		IOUtils.addLog("lpop " + key, lpop);
//		System.out.println(">>> lpop " + key);
//		System.out.println(">>> " + lpop);
//		
//		String rpop = jedis.rpop(key);
//		IOUtils.addLog("rpop " + key, rpop);
//		System.out.println(">>> rpop " + key);
//		System.out.println(">>> " + rpop);
		
		String command_lindex = "lindex " + key;
		String lindexStr = jedis.lindex(key, 0);
		IOUtils.addLog(command_lindex, lindexStr);
		
		jedis.close();
	}
}
