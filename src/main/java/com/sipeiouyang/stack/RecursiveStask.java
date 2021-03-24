package com.sipeiouyang.stack;

import java.util.Deque;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 一个栈依次压入 1、2、3、4、5，那么从栈顶到栈底分别为 5、4、3、2、1。将这个栈转置后，
 * 从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，
 * 不能用其他数据结构。
 *
 */
public class RecursiveStask {

    public static Deque<Integer> convert(Deque<Integer> deque){
        if (deque == null){
            throw new RuntimeException("deque is empty");
        }
        reverse(deque);
        return deque;
    }

    /**
     * @Author: sipeiouyang
     * @DateTime: 2021/3/24 10:12 下午
     * @param deque
     * @return void
     * @Description:
     *
     * 这个函数的作用就是将栈反转
     **/
    private static void reverse(Deque<Integer> deque){
        if (deque.size() == 0){
            return;
        }
        Integer cache = getLastAndRemove(deque);
        reverse(deque);
        deque.push(cache);
        return;
    }

    private static Integer getLastAndRemove(Deque<Integer> deque){
        Integer cache = deque.pop();
        if (deque.size() == 0){
            return cache;
        }
        Integer next = getLastAndRemove(deque);
        deque.push(cache);
        return next;
    }

}
