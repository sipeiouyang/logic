package com.sipeiouyang.dp;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class MinPathSumTest extends LogicTest {

    @Test
    public void test(){
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        Assert.assertEquals(MinPathSum.fun1(arr).intValue(), 12);
        Assert.assertEquals(MinPathSum.fun2(arr).intValue(), 12);
    }

}
