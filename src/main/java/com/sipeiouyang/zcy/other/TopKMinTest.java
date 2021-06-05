package com.sipeiouyang.zcy.other;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class TopKMinTest extends LogicTest {

    @Test
    public void topKTest(){
        int[] arr = {6,5,7,8,9,4,1,3,2,6};
        int[] res = TopKMin.topK(arr, 5);
        for (int i = 5; i > 0; i--){
            Assert.assertEquals(i, res[5 - i]);
        }
    }
}
