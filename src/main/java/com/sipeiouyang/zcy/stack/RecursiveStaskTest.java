package com.sipeiouyang.zcy.stack;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class RecursiveStaskTest extends LogicTest {

    @Test
    public void test(){
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < 100; i++){
            deque.push(i);
        }
        RecursiveStask.convert(deque);
        for (int i = 0; i < 100; i++){
            System.out.println(i);
            Assert.assertEquals(i, deque.pop().intValue());
        }
    }

}
