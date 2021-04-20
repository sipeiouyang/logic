package com.sipeiouyang.stack;

import org.springframework.util.CollectionUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 用一个栈实现另一个栈的排序
 *
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一
 * 个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序?
 */
public class SortStackByStack {

    public static void sortStackByStack(Stack<Integer> stack){
         if (CollectionUtils.isEmpty(stack)){
             return;
         }
         Deque<Integer> deque = new LinkedList<>();
         while (!stack.isEmpty()){
             Integer cur = stack.pop();
             while (!deque.isEmpty() && cur > deque.peek()){
                 stack.push(deque.pop());
             }
             deque.push(cur);
         }
         while (!deque.isEmpty()){
             stack.push(deque.pop());
         }
    }

}
