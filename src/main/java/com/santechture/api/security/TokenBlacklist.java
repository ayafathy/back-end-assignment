package com.santechture.api.security;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBlacklist {
	 private static Set<String> blacklist = ConcurrentHashMap.newKeySet();

	    public static void addToBlacklist(String token) {
	        blacklist.add(token);
	    }

	    public static boolean isBlacklisted(String token) {
	        return blacklist.contains(token);
	    }
}
