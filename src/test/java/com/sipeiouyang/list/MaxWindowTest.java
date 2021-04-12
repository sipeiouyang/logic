package com.sipeiouyang.list;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class MaxWindowTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] result = MaxWindow.getMaxWindow(arr, 3);
        Assert.assertEquals(result.length, 6);
    }

}
