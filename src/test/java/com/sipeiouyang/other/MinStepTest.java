package com.sipeiouyang.other;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class MinStepTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {3,2,3,1,1,4};
        int less = MinStep.getMinStep(arr);
        Assert.assertEquals(less, 2);
    }
}
