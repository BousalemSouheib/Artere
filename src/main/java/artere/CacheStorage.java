package artere;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheStorage {

    private static final Map<String, CacheElement> cache = new ConcurrentHashMap<>();

    public static Map<String, CacheElement> getCache() {
        return cache;
    }

    public static void setCache(CacheElement entry) {
        cache.put(entry.getKey(), entry);
    }
}
