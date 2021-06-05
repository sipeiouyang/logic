package com.sipeiouyang.zcy.stack;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class SortStackByStackTest extends LogicTest {

    @Test
    public void test(){
        Stack<Integer> stack = new Stack<>();
        for(int i = 10; i > 0; i--){
            stack.push(i);
        }
        SortStackByStack.sortStackByStack(stack);
        for (int i = 10; i > 0; i--){
            Assert.assertTrue(stack.pop().equals(i));
        }
    }

}
