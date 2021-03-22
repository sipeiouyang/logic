package com.sipeiouyang.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *
 * 要求
 * 1.pop、push、getMin 操作的时间复杂度都是 O(1)。
 * 2.设计的栈类型可以使用现成的栈结构。
 *
 *
 */
public class GetMinStack {

    /**
     * 核心deque
     **/
    private Deque<Integer> core = new LinkedList<>();

    /**
     * 最小值deque
     **/
    private Deque<Integer> min = new LinkedList<>();

    public void push(Integer num){
        core.push(num);
        if (min.size() == 0){
            min.add(num);
            return;
        }
        int currentMin = min.peek();
        if (currentMin < num){
            min.push(currentMin);
            return;
        }
        min.push(num);
    }

    public Integer pop(){
        if (core.size() == 0){
            throw new RuntimeException("stack is empty");
        }
        min.pop();
        return core.pop();
    }

    public Integer getMin(){
        if (core.size() == 0){
            throw new RuntimeException("stack is empty");
        }
        return min.peek();
    }


}
