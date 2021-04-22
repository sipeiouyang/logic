package com.sipeiouyang.stack;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class NearLessArrTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {3,4,1,5,6,2,7};
        int[][] result = NearLessArr.getNearLessNoRepeat(arr);
        for (int i = 0; i < result.length; i++){
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
        Assert.assertTrue(result.length == 7);
        System.out.println("-------------");
        int[] arr2 = {3,1,3,4,3,5,3,2,2};
        result = NearLessArr.getNearLessRepeat(arr2);
        for (int i = 0; i < result.length; i++){
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }

}
