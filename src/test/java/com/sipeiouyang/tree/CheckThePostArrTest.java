package com.sipeiouyang.tree;

import com.sipeiouyang.LogicTest;
import com.sipeiouyang.tree.domain.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class CheckThePostArrTest extends LogicTest {

    @Test
    public void test(){
        int[] arr = {2,1,3,6,5,7,4};
        Assert.assertEquals(true, CheckThePostArr.check(arr));
        int[] arr2 = {2,1,8,6,5,7,4};
        Assert.assertEquals(false, CheckThePostArr.check(arr2));
        Node root = GenerateTreeByPostArr.generateTree(arr);
        Assert.assertEquals(4, root.value);
    }

}
