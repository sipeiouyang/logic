package com.sipeiouyang.linked.domain;

/**
 * @author sipeiouyang
 * @version 1.0
 */
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;
    public DoubleNode(int data) {
        this.value = data;
    }
}
