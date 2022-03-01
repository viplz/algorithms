package com.lz.leecode;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lian-zhang
 * @version 1.0
 * @ClassName LRUCache.java
 * @Description TODO
 * @createTime 2022年02月11日 23:13:49
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V>{

    private int capacity;

    /**
     * accessOrder – the ordering mode - true for access-order, false for insertion-order
     * @param capacity
     */
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }
}
