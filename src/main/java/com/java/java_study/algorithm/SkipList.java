package com.java.java_study.algorithm;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Random;

/**
 * 调表是redis有序集合的实现之一 设计的原理是为了代替平衡树
 * 有序集合查找需要实现区间的查找数据，在时间复杂度上跳表的实现要比红合数高效，直接从原始链表上往后遍历即可
 * 实现灵活，比红黑树简单，构建索引有效平衡效率与内存消耗。
 * @author xcxu
 * @data 2019/8/27
 **/
public class SkipList<K extends Comparable<K>, V> {

    @Getter
    @Setter
    static final class Node<K extends Comparable<K>, V> {
        private K key;

        private V value;

        private Node<K, V> up, down, pre, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }



        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", hashcode=" + hashCode() +
                    ", up=" + (up == null ? "null" : up.hashCode()) +
                    ", down=" + (down == null ? "null" : down.hashCode()) +
                    ", pre=" + (pre == null ? "null" : pre.hashCode()) +
                    ", next=" + (next == null ? "null" : next.hashCode()) +
                    '}';
        }
    }

    private Node<K, V> head;//k,v都是NULL

    private Integer levels = 0;

    private Integer length = 0;

    /**
     * 抛硬币上升法
     */
    private Random random = new Random(System.currentTimeMillis());

    public SkipList() {
        createNewLevel();
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }

        Node<K, V> newNode = new Node<>(key, value);
        insertNode(newNode);
    }

    private void insertNode(Node<K, V> newNode) {
        Node<K, V> curNode = findNode(newNode.getKey());
        if (curNode.getKey() == null) {
            insertNext(curNode, newNode);
        } else if (curNode.getKey().compareTo(newNode.getKey()) == 0) {
            //update
            curNode.setValue(newNode.getValue());
            return;
        } else {
            insertNext(curNode, newNode);
        }

        int currentLevel = 1;
        Node<K, V> oldTop = newNode;
        /**
         * 抛硬币上升法，大于50什么都不用处理，小于50则需要将该节点上升
         */
        while (random.nextInt(100) < 50) {
            Node<K, V> newTop = new Node<>(newNode.getKey(), null);

            if (currentLevel >= levels) {
                createNewLevel();
            }

            while (curNode.getPre() != null && curNode.getUp() == null) {
                curNode = curNode.getPre();
            }

            if (curNode.getUp() == null) {
                continue;
            }

            curNode = curNode.getUp();
            Node<K, V> curNodeNext = curNode.getNext();

            curNode.setNext(newTop);
            newTop.setPre(curNode);
            newTop.setDown(oldTop);
            oldTop.setUp(newTop);

            newTop.setNext(curNodeNext);
            oldTop = newTop;

            currentLevel++;
        }
    }

    private void createNewLevel() {
        Node<K, V> newHead = new Node<>(null, null);
        if (this.head == null) {
            this.head = newHead;
            this.levels++;
            return;
        }

        this.head.setUp(newHead);
        newHead.setDown(this.head);
        this.head = newHead;
        this.levels++;
    }

    private void insertNext(Node<K, V> curNode, Node<K, V> newNode) {
        Node<K, V> curNodeNext = curNode.getNext();
        newNode.setNext(curNodeNext);
        if (curNodeNext != null) {
            curNodeNext.setPre(newNode);
        }
        curNode.setNext(newNode);
        newNode.setPre(curNode);

        this.length++;
    }

    public V get(K key) {
        Node<K, V> node = findNode(key);
        if (key.equals(node.getKey())) {
            return node.getValue();
        }

        return null;
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> curNode = this.head;

        for (; ; ) {
            while (curNode.getNext() != null && curNode.getNext().getKey().compareTo(key) <= 0) {
                curNode = curNode.getNext();
            }

            if (curNode.getDown() != null) {
                curNode = curNode.getDown();
            } else {
                break;
            }
        }

        return curNode;
    }

    public void print() {
        Node<K, V> curI = this.head;

        String[][] strings = new String[levels][length + 1];
        for (String[] string : strings) {
            Arrays.fill(string, "0");
        }

        while (curI.getDown() != null) {
            curI = curI.getDown();
        }

        System.out.println("levels:" + levels + "_" + "length:" + length);

        int i = 0;
        while (curI != null) {
            Node<K, V> curJ = curI;

            int j = levels - 1;
            while (curJ != null) {
                strings[j][i] = String.valueOf(curJ.getKey());

                if (curJ.getUp() == null) {
                    break;
                }
                curJ = curJ.getUp();
                j--;
            }

            if (curI.getNext() == null) {
                break;
            }
            curI = curI.getNext();
            i++;
        }

        for (String[] string : strings) {
            System.out.println(Arrays.toString(string));
        }
    }

    public static void main(String[] args) {

        SkipList<Integer, String> skipList = new SkipList<>();

        skipList.put(2, "B");
        skipList.put(2, "G");
        skipList.put(2, "H");
        skipList.put(1, "A");
        skipList.put(3, "C");
        skipList.put(6, "E");

        skipList.print();

        System.out.println(skipList.get(2));

    }

}