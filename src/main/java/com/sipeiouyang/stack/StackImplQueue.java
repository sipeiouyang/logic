package com.sipeiouyang.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 由两个栈组成的队列
 *
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)。
 */
public class StackImplQueue {

    private Deque<Integer> pushDeque;
    private Deque<Integer> popDeque;

    public StackImplQueue() {
        pushDeque = new LinkedList<>();
        popDeque = new LinkedList<>();
    }

    public void add(Integer integer){
        pushDeque.push(integer);
        move();
    }

    public Integer pop(){
        if (pushDeque.size() == 0 && popDeque.size() == 0){
            throw new RuntimeException("queue is empty");
        }
        move();
        return popDeque.pop();
    }

    public Integer peek(){
        if (pushDeque.size() == 0 && popDeque.size() == 0){
            throw new RuntimeException("queue is empty");
        }
        move();
        return popDeque.peek();
    }



    private void move(){
        if (popDeque.size() == 0){
            while (pushDeque.size() != 0){
                popDeque.push(pushDeque.pop());
            }
        }
    }

}
