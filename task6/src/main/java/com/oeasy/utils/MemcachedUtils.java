package com.oeasy.utils;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class MemcachedUtils {
	 private static MemCachedClient cachedClient;
	    static {
	        if (cachedClient == null) {
	            cachedClient = new MemCachedClient("memCachedPool");
	        }
	    }

	    private MemcachedUtils() {}
	    /**
	     * 向缓存添加键值对。注意：如果键已经存在，则之前的键对应的值将被替换
	     * @param key
	     * @param value
	     * @return
	     */
	    public static boolean set(String key, Object value) {
	        return setExp(key, value, null);
	    }
	    /**
	     * 向缓存添加键值对并为该键值对设定逾期时间（即多长时间后该键值对从Memcached内存缓存中删除，比如： new Date(1000*10)，
	     * 则表示十秒之后从Memcached内存缓存中删除）。注意：如果键已经存在，则之前的键对应的值将被替换。
	     * @param key
	     * @param value
	     * @param expire
	     * @return
	     */
	    public static boolean set(String key, Object value, Date expire) {
	        return setExp(key, value, expire);
	    }

	    private static boolean setExp(String key, Object value, Date expire) {
	        boolean flag = false;
	        try {
	            flag = cachedClient.set(key, value, expire);
	        } catch (Exception e) {

	        }
	        return flag;
	    }

	    public static boolean add(String key, Object value) {
	        return addExp(key, value, null);
	    }

	    public static boolean add(String key, Object value, Date expire)
	    {
	        return addExp(key, value, expire);
	    }

	    private static boolean addExp(String key, Object value, Date expire) {
	        boolean flag = false;
	        try {
	            flag = cachedClient.add(key, value, expire);
	        } catch (Exception e) {

	        }
	        return flag;
	    }

	    public static boolean replace(String key, Object value)
	    {
	        return replaceExp(key, value, null);
	    }

	    /**
	     * 仅当键已经存在时，replace 命令才会替换缓存中的键。
	     *
	     * @param key
	     *            键
	     * @param value
	     *            值
	     * @param expire
	     *            过期时间 New Date(1000*10)：十秒后过期
	     * @return
	     */
	    public static boolean replace(String key, Object value, Date expire)
	    {
	        return replaceExp(key, value, expire);
	    }

	    /**
	     * 仅当键已经存在时，replace 命令才会替换缓存中的键。
	     *
	     * @param key
	     *            键
	     * @param value
	     *            值
	     * @param expire
	     *            过期时间 New Date(1000*10)：十秒后过期
	     * @return
	     */
	    private static boolean replaceExp(String key, Object value, Date expire)
	    {
	        boolean flag = false;
	        try
	        {
	            flag = cachedClient.replace(key, value, expire);
	        }
	        catch (Exception e)
	        {

	        }
	        return flag;
	    }

	    /**
	     * get 命令用于检索与之前添加的键值对相关的值。
	     *
	     * @param key
	     *            键
	     * @return
	     */
	    public static Object get(String key)
	    {
	        Object obj = null;
	        try
	        {
	            obj = cachedClient.get(key);
	        }
	        catch (Exception e)
	        {

	        }
	        return obj;
	    }

	    /**
	     * 删除 memcached 中的任何现有值。
	     *
	     * @param key
	     *            键
	     * @return
	     */
	    public static boolean delete(String key)
	    {
	        return deleteExp(key, null);
	    }

	    /**
	     * 删除 memcached 中的任何现有值。
	     *
	     * @param key
	     *            键
	     * @param expire
	     *            过期时间 New Date(1000*10)：十秒后过期
	     * @return
	     */
	    public static boolean delete(String key, Date expire)
	    {
	        return deleteExp(key, expire);
	    }

	    /**
	     * 删除 memcached 中的任何现有值。
	     *
	     * @param key
	     *            键
	     * @param expire
	     *            过期时间 New Date(1000*10)：十秒后过期
	     * @return
	     */
	    private static boolean deleteExp(String key, Date expire)
	    {
	        boolean flag = false;
	        try
	        {
	            flag = cachedClient.delete(key, expire);
	        }
	        catch (Exception e)
	        {

	        }
	        return flag;
	    }

	    /**
	     * 清理缓存中的所有键 / 值对
	     *
	     * @return
	     */
	    public static boolean flashAll()
	    {
	        boolean flag = false;
	        try
	        {
	            flag = cachedClient.flushAll();
	        }
	        catch (Exception e)
	        {

	        }
	        return flag;
	    }	
}
