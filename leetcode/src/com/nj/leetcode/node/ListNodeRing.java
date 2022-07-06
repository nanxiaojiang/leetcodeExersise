package com.nj.leetcode.node;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 南江
 * @Description:    判断是否存在链环
 * @Date 2022/7/2 23:12
 */
public class ListNodeRing {


    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }


    /**
     * 龟兔赛跑：
     *  定义两个指针，一快一满。慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next。
     *  移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。
     */
    public static boolean quickAndSlow(ListNode head){
        if (head == null || head.next == null){
            return false;
        }

        ListNode quick = head.next;
        ListNode slow = head;

        while (quick != slow){
            if (quick == null || quick.next == null){
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     *   遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过
     *   使用哈希表存储
     */
    public static boolean returnBoolean(ListNode head){
        Set<ListNode> set = new HashSet<>();
        // 如果不为空则继续遍历
        while (head != null){
            //如果set添加成功返回true，添加不能成返回false 则代表有链环既return true
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
