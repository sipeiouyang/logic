package com.sipeiouyang.zcy.sort;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class QuickSortTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {9,0,2,3,4,1,7,6,8,5};
        QuickSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(i, arr[i]);
        }
    }

}
