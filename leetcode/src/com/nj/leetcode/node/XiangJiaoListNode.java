package com.nj.leetcode.node;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 南江
 * @Description:
 * @Date 2022/7/1 2:03
 */
public class XiangJiaoListNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *
     * @param headA headA走完自己的在走一遍headB
     * @param headB headB走完自己的在走一遍headA
     * @return  如果两者相遇则就有相遇点
     */
    public static ListNode returnNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode hA = headA,hB = headB;
        while (hA != hB){
            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return  hA;
    }


    /**
     * 使用Hash，先将headA都放在在set当中   在遍历headB 如果又包含的就返回 没有返回null
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode returnNumber(ListNode headA, ListNode headB){
        Set<ListNode> hashSet = new HashSet<>();
        //将headA都放入set
        ListNode temp = headA;
        while (temp != null){
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            if (hashSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }



    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
