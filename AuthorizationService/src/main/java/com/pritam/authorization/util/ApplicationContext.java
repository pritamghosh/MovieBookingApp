package com.pritam.authorization.util;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
	private static Map<String, Object> contextMap = new HashMap<>();

	public static Object get(String key) {
		return contextMap.get(key);
	}

	public static Object put(String key, Object value) {
		return contextMap.put(key, value);
	}

	public static Object remove(String key) {
		return contextMap.remove(key);
	}
}
