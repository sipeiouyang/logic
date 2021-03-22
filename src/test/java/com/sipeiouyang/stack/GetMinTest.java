package com.sipeiouyang.stack;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class GetMinTest extends LogicTest {

    @Test
    public void test(){
        GetMinStack stack = new GetMinStack();
        stack.push(1);
        stack.push(2);
        Assert.assertTrue(stack.getMin().equals(1));
        Assert.assertTrue(stack.pop().equals(2));
        Assert.assertTrue(stack.pop().equals(1));
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        Assert.assertTrue(stack.getMin().equals(1));
        Assert.assertTrue(stack.pop().equals(3));
        Assert.assertTrue(stack.getMin().equals(1));
        Assert.assertTrue(stack.pop().equals(1));
        Assert.assertTrue(stack.getMin().equals(2));
        Assert.assertTrue(stack.pop().equals(2));
        Assert.assertTrue(stack.getMin().equals(4));
    }

}
