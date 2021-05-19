package com.sipeiouyang.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 *
 * 括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但 "([)]" 则是无效的括号。
 */
public class Solution {
    public boolean isValidParentheses(String s) {
        if(s == null){
            return false;
        }
        Deque<Character> deque = new LinkedList();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
                deque.push(arr[i]);
            }else if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']'){
                if (deque.size() == 0){
                    return false;
                }
                if (arr[i] == ')'){
                    if (deque.pop() != '('){
                        return false;
                    }
                }
                if (arr[i] == '}'){
                    if (deque.pop() != '{'){
                        return false;
                    }
                }
                if (arr[i] == ']'){
                    if (deque.pop() != '['){
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return deque.size() == 0;
    }
}
