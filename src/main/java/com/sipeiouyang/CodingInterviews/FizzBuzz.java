package com.sipeiouyang.CodingInterviews;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 *
 * Fizz Buzz 问题
 *
 * 描述
 * 给定整数 n ，按照如下规则打印从 1 到 n 的每个数：
 *
 * 如果这个数被3整除，打印fizz。
 * 如果这个数被5整除，打印buzz。
 * 如果这个数能同时被3和5整除，打印fizz buzz。
 * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 *
 *
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList();
        for(int i = 1; i <= n; i++){
            list.add(getPrintString(i));
        }
        return list;
    }


    private String getPrintString(int i){
        if (i % 3 == 0 && i % 5 == 0){
            return "fizz buzz";
        }
        if (i % 3 == 0){
            return "fizz";
        }
        if (i % 5 == 0){
            return "buzz";
        }
        return String.valueOf(i);
    }
}
