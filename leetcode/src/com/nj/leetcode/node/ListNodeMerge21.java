package com.nj.leetcode.node;

/**
 * @Author 南江
 * @Description: 合并两个链表保证有序
 * @Date 2022/5/16 22:14
 */
public class ListNodeMerge21 {
    /**
     *  M和N 为两个链表的长度
     *  时间复杂度为O(M+N)；空间复杂度为O(1)
     */
    public static void main(String[] args) {
        //定义初始化链表
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        //定义父级listNode（未知节点）
        ListNode prevHead = new ListNode(-1);
        //perv等于未知节点，用于去和其他两个listNode当作元素进行比较
        ListNode prev = prevHead;

        while (list1 != null && list2 != null){
            //如果list1的值小于list2的值
            if (list1.val < list2.val){
                //刚开始是未知节点的next是当前小的节点list1
                prev.next = list1;
                //list1等于list的next
                list1 = list1.next;
            }else {
                //反之则，刚开始是未知节点的next节点是当前小的节点list2
                prev.next = list2;
                //list2等于list2的next
                list2 = list2.next;
            }

            prev = prev.next;
        }

        //合并之后，最后会剩下一个数据没有合并，直接将链表末尾指向未合并完成的数据即可
        prev.next = list1 == null ? list2:list1;
        ListNode resultListNode = prevHead.next;
        System.out.println(resultListNode);
    }

    /**
     * 暴力解法：递归
     * 时间复杂度和空间复杂度都为O(M+N)
     * 不考虑极端情况，默认l,l2都是有值
     */
    class TestBaoLiResult{
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //如果l1为null，直接返回l2
            if (l1 == null){
                return  l2;
            }else if (l2 == null){
                //如果l2为null，直接返回l1
                return  l1;
            }else if (l1.val < l2.val){
                //如果l1的值小于l2的值，递归l1.next = mergeTwoLists(l1.next,l2)
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                //否则l2的值小于l1的值，递归l2.next = mergeTwoList(l1,l2.next)
                l2 = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
    }

    /**
     * 定义的ListNode
     */
    static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
