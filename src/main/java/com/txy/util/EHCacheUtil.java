package com.txy.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheUtil {
	private static CacheManager cacheManager;

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

	public static void setCacheManager(CacheManager cacheManager) {
		EHCacheUtil.cacheManager = cacheManager;
	}

	public static Object getCacheElement(String cacheKey) throws Exception {

		Cache cache = cacheManager.getCache("mycache");

		net.sf.ehcache.Element e = cache.get(cacheKey);
		if (e == null) {
			return null;
		}
		return e.getValue();
	}

	/*
	 * 将对象添加到缓存中
	 */
	public static void addToCache(String cacheKey, Object result) throws Exception {
		Cache cache = cacheManager.getCache("mycache");
		Element element = new Element(cacheKey, result);
		cache.put(element);
	}

}
