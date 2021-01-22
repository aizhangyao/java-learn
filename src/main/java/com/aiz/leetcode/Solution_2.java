package com.aiz.leetcode;

/**
 * @ClassName Solution_1
 * @Description https://leetcode-cn.com/problems/add-two-numbers/
 * @Author Zhang Yao
 * @Date Create in 17:01 2021/1/21 0021
 * @Version 1.0
 */
public class Solution_2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //2 - 4 - 3
        //5 - 6 - 4
        //8 - 0 - 7
        ListNode sum = new ListNode();
        boolean step = false;
        do{

        } while(l1.next!=null || l2.next != null);

        int n1 = 0;
        int n2 = 0;
        return null;
    }



}
