package com.sipeiouyang.other;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class LRUCacheTest extends LogicTest {

    @Test
    public void test(){
        LRUCache<String, String> lruCache = new LRUCache<>(2);
        lruCache.set("1", "1");
        lruCache.set("2", "2");
        lruCache.set("3", "3");
        Assert.assertEquals(null, lruCache.get("1"));
        Assert.assertEquals("3", lruCache.get("3"));
        Assert.assertEquals("2", lruCache.get("2"));
        lruCache.set("1", "1");
        Assert.assertEquals(null, lruCache.get("3"));
        Assert.assertEquals(2, lruCache.size());
        lruCache.set("4", "4");
        Assert.assertEquals(null, lruCache.get("2"));
    }

}
