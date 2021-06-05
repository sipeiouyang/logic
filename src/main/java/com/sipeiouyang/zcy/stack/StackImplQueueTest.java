package com.sipeiouyang.zcy.stack;

import com.sipeiouyang.LogicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class StackImplQueueTest extends LogicTest {

    @Test
    public void test(){
        StackImplQueue queue = new StackImplQueue();
        try {
            queue.peek();
        }catch (Exception e){
            Assert.assertEquals("queue is empty", e.getMessage());
        }
        try {
            queue.pop();
        }catch (Exception e){
            Assert.assertEquals("queue is empty", e.getMessage());
        }
        queue.add(1);
        queue.add(2);
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertEquals(1, queue.pop().intValue());
        Assert.assertEquals(2, queue.peek().intValue());
        Assert.assertEquals(2, queue.pop().intValue());
        try {
            queue.peek();
        }catch (Exception e){
            Assert.assertEquals("queue is empty", e.getMessage());
        }
        try {
            queue.pop();
        }catch (Exception e){
            Assert.assertEquals("queue is empty", e.getMessage());
        }
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertEquals(1, queue.pop().intValue());
        queue.add(4);
        queue.add(5);
        queue.add(6);
        Assert.assertEquals(2, queue.pop().intValue());
        Assert.assertEquals(3, queue.pop().intValue());
        Assert.assertEquals(4, queue.pop().intValue());
        Assert.assertEquals(5, queue.pop().intValue());
        Assert.assertEquals(6, queue.pop().intValue());

    }

}
