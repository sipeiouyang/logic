package com.sipeiouyang.zcy.dp;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class MinCoinsTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {5,2,3};
        Assert.assertEquals(MinCoins.minCoins(arr, 20), 4);
        Assert.assertEquals(MinCoins.minCoins(arr, 0), 0);
        Assert.assertEquals(MinCoins.minCoins(arr, 1), -1);
        Assert.assertEquals(MinCoins.minCoins(arr, 2), 1);
        Assert.assertEquals(MinCoins.minCoins(arr, 3), 1);
        Assert.assertEquals(MinCoins.minCoins(arr, 5), 1);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 20), 4);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 0), 0);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 1), -1);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 2), 1);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 3), 1);
        Assert.assertEquals(MinCoins.minCoinsDp(arr, 5), 1);
    }
}
