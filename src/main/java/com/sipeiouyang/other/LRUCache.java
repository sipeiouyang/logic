package com.sipeiouyang.other;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 设计 LRU 缓存结构，该结构在构造时确定大小，假设大小为 K，并有如下两个功能。
 * 1.set(key,value):将记录(key,value)插入该结构。
 * 2.get(key):返回 key 对应的 value 值。
 *
 * 要求
 * 1.set 和 get 方法的时间复杂度为 O(1)。
 * 2.某个 key 的 set 或 get 操作一旦发生，认为这个 key 的记录成了最常使用的。
 * 3.当缓存的大小超过 K 时，移除最不经常使用的记录，即 set 或 get 最久远的。
 *
 * 使用双端队列加HashMap
 */
public class LRUCache<K,V> {

    private HashMap<K, Node<V>> map;

    private HashMap<Node<V>, K> listMap;

    private Node<V> head = new Node();

    private Node<V> last = new Node();

    private int capacity;

    public LRUCache(int size) {
        if (size < 1){
            throw new RuntimeException("size error");
        }
        map = Maps.newHashMapWithExpectedSize(size);
        listMap = Maps.newHashMapWithExpectedSize(size);
        capacity = size;
        head.next = last;
        last.pre = head;
    }

    public V get(K key){
        Node<V> node = map.get(key);
        if (Objects.nonNull(node)){
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            addNodeToHead(node);
            return node.value;
        }
        return null;
    }

    public void set(K key, V value){
        Node node = map.get(key);
        if (Objects.isNull(node)){
            if (map.size() == capacity){
                removeLastNode();
            }
            node = new Node(value);
            addNodeToHead(node);
            map.put(key, node);
            listMap.put(node, key);
            return;
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        addNodeToHead(node);
    }

    public int size(){
        return map.size();
    }

    /**
     * 将node移动到头节点
     **/
    private void addNodeToHead(Node node){
        Node moveNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = moveNode;
        moveNode.pre = node;
    }

    /**
     * 删除最后一个节点
     **/
    private void removeLastNode(){
        Node pre = last.pre;
        last.pre = pre.pre;
        pre.pre.next = last;
        K key = listMap.get(pre);
        listMap.remove(pre);
        map.remove(key);
    }

    private static class Node<V>{

        V value;

        Node<V> next = null;

        Node<V> pre = null;

        public Node(V value) {
            this.value = value;
        }

        public Node() {
        }
    }

}
