package com.crowdfunding.framework.redis;

import com.crowdfunding.framework.util.PropertiesLoader;
import com.crowdfunding.framework.util.SerializeUtil;
import com.crowdfunding.framework.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  Redis工具类
 * Created by lucy on 2017/12/11.
 */
public class RedisUtil {
    //TODO: configure all the parameters here with other way:
    //Redis服务器IP
    private static final String ADDRESS = PropertiesLoader.getConfig("redis.address");

    //Redis端口号
    private static final int PORT = Integer.parseInt(PropertiesLoader.getConfig("redis.port"));

    private static final String AUTH = PropertiesLoader.getConfig("jedis.auth");

    //可用连接实例的最大数目，如果为-1表示不限制。
    private static final int MAX_TOTAL = Integer.parseInt(PropertiesLoader.getConfig("redis.max_total"));

    //最大空闲实例
    private static final int MAX_IDLE = Integer.parseInt(PropertiesLoader.getConfig("redis.max_idle"));

    //等待可用连接的最大时间，单位毫秒，默认为-1, 表示永不超时
    //如果超过等待时间，则抛出JedisConnectionException
    private static final int MAX_WAIT = Integer.parseInt(PropertiesLoader.getConfig("redis.max_wait"));

    //等待响应时间
    private static final int TIMEOUT = Integer.parseInt(PropertiesLoader.getConfig("redis.timeout"));

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static final boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    private static String ALPHAWIN = "ALPHAWIN_";

    private static int time = 60 * 30;
    /**
     * 初始化Redis连接池
     */
    static{
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_TOTAL);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        if (StringUtil.isEmpty(AUTH)) {
            jedisPool = new JedisPool(config, ADDRESS, PORT, TIMEOUT);
        } else {
            jedisPool = new JedisPool(config, ADDRESS, PORT, TIMEOUT, AUTH);
        }
    }

    /**
     * 获取Jedis实例
     */
    public static Jedis getJedis(){
        if(null == jedisPool) return null;
        synchronized(jedisPool){
            return jedisPool.getResource();
        }
    }

    /**
     * 释放Jedis资源
     */
    public static void returnResource(final Jedis jedis){
        if(null != jedis) jedis.close();
    }

    /**
     * 根据KEY 更新缓存
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @param value
     */
    public static void putCache(String key ,String value){
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * 根据KEY 更新缓存
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @param value
     */
    public static void putCache(byte[] key ,byte[] value){
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * 根据KEY 获取值
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @return
     */
    public static String getCache(String key){
        String value = null;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }

        return value;
    }

    /**
     * 根据KEY 获取值
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @return
     */
    public static byte[] getCache(byte[] key){
        byte[] value = null;
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }

        return value;
    }


    /**
     * 根据key 获取hash对象
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @return
     */
    public static Map<String,String> getCacheHash(String key) {
        Map<String,String> map = null;
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }

        return map;
    }

    /**
     * 根据key 更新hash对象
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     * @return
     */
    public static void putHashCache(String key, Map<String,String> hash) {
        Jedis jedis = null;

        try {

            jedis = jedisPool.getResource();
            jedis.hmset(key, hash);
            jedis.expire(key, 10 * 86400);	//生命有效期10天
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * 根据KEY 删除缓存
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param key
     */
    public static void deleteCache(String key){
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * 删除多个
     * @author: lucy
     * @date:2017/12/11 16:35
     * @param keys
     */
    public static void deleteCaches(String keys) {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            Set<String> keySet = jedis.keys(keys);
            for (String key : keySet) {
                jedis.del(key);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    public static Long setNx(String key,String value) {
        Jedis jedis = null;
        Long  ret = 0l;
        try {
            jedis = jedisPool.getResource();
            ret = jedis.setnx(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
        return ret;
    }

    /**
     * @Description 设置redis key值有效时长
     * @MethodName
     * @param
     * @return
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static void putCache(String key, String value,int ableSeconds) {
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            jedis.set(key,value);
            jedis.expire(key, ableSeconds);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }


    /**
     * 未加事务控制
     * @deprecated starting from 1.1 this method will not be exposed.
     *   The object (is an implementation of @see{ @link com.winchampion.credit.core3.zmess.utils.Serializable})
     *   stored into Redis should be serialized with @see{ @link com.winchampion.credit.core3.zmess.utils.Serializable#serialize()}。
     *   And it can be unserialized to the orgin object with
     *   @see{ @link com.winchampion.credit.core3.zmess.utils.Serializable#unSerialize()}。
     * @param key
     * @param hashElement
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @since 1.0
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    public static final <T> void helpStoreHash(String key, T hashElement) throws IllegalArgumentException, IllegalAccessException{
        if(null == hashElement) throw new RuntimeException("null can not be helped to store to the redis."); //TODO: custom exception
        Jedis jedis = getJedis();
        //TODO: need transaction?
        Pipeline pipeline = jedis.pipelined();
        Class<?> clazz = hashElement.getClass();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            Object obj = field.get(hashElement);
            //TODO: more careful handle. to think if reflect failed
            if(field.getType().equals(String.class)) pipeline.hset(key, field.getName(), (String)obj);
            else if(field.getType().equals(Map.class)) {
                Map<String, String> map = (Map<String, String>)obj;
                Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
                while(iter.hasNext()){
                    Map.Entry<String, String> entry = iter.next();
                    pipeline.hset(key, entry.getKey(), entry.getValue());
                }
            }
        }
        pipeline.sync();
        returnResource(jedis);
    }

    public static synchronized String jedisIncreasing(String key, String defalut) {
        Jedis jedis = null;
        String increasing = "";
        try {
            jedis = jedisPool.getResource();
            if (StringUtils.isNotEmpty(defalut)) {
                if (!jedis.exists(key)) {
                    jedis.set(key, defalut);
//		                jedis.expire(key, time);
                }
                return jedis.get(key);
            }
            jedis.incr(key);
            increasing = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
        return increasing;
    }

    /**
     * @param key
     * @param obj
     * @return void
     * @Description 保存对象到redis
     * 对象必须可序列化，实现java.io.Serializable接口
     * @MethodName jedisPutObject
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized void jedisPutObject(String key, Object obj) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key.getBytes())) {
                jedis.del(key.getBytes());
            }
            jedis.set(key.getBytes(), SerializeUtil.serialize(obj), "NX".getBytes(), "EX".getBytes(), (long) time);
//	        jedis.expire(key.getBytes(), time);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @return java.lang.Object
     * @Description redis中获取对象
     * @MethodName jedisGetObject
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized Object jedisGetObject(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return SerializeUtil.unserialize(jedis.get(key.getBytes()));
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @return java.lang.Boolean
     * @Description redis中删除对象
     * @MethodName jedisRemoveObject
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized Boolean jedisRemoveObject(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key.getBytes()) > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @param value
     * @return void
     * @Description set中新增一个元素
     * @MethodName jedisAddSet
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized void jedisAddSet(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.sadd(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @return java.util.Set<java.lang.String>
     * @Description 获取Set
     * @MethodName jedisGetSet
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized Set<String> jedisGetSet(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                return jedis.smembers(key);
            }
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @param value
     * @return void
     * @Description 移除Set中的某一个元素
     * @MethodName jedisRemoveSetStr
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized void jedisRemoveSetStr(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                jedis.srem(key, value);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

    /**
     * @param key
     * @param member
     * @return java.lang.Boolean
     * @Description set中是否包含某个值
     * @MethodName jedisSetContains
     * @author lucy
     * @Date 2017/12/11 16:35
     */
    public static synchronized Boolean jedisSetContains(String key, String member) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.sismember(key, member);
        } catch (Exception e) {
            throw e;
        } finally {
            //返还到连接池
            returnResource(jedis);
        }
    }

}
