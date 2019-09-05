package com.java.java_study.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 链表划分
 * 携程笔试第一题
 */
public class Partition {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    static ListNode partition(ListNode head,int m) {
        try {

            if (head ==null|| head.next ==null) {
                return head;
            }
            /**
             * 接下来就是构建结果ListNode
             */
            ListNode result = null;
            List<Integer> listBig = new ArrayList<Integer>();
            List<Integer> listLittle = new ArrayList<Integer>();
            ListNode temp = head;
            if (head.val <= m) {
                listLittle.add(head.val);
            } else {
                listBig.add(head.val);
            }
            while (temp.next!=null) {
                temp = temp.next;
                if (temp.val <= m) {
                    listLittle.add(temp.val);
                } else {
                    listBig.add(temp.val);
                }
            }
            ListNode node = null;
            for (Integer item : listLittle) {
                if (result == null) {
                    node = new ListNode(item.intValue());
                    result = node;
                } else {
                    node.next = new ListNode(item.intValue());
                    node = node.next;
                }
            }
            for (Integer item : listBig) {
                if (result == null) {
                    node = new ListNode(item.intValue());
                    result = node;
                } else {
                    node.next = new ListNode(item.intValue());
                    node = node.next;
                }
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return head;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
