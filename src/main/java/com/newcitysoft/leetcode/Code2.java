package com.newcitysoft.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 2. 两数相加
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 * <pre>
 *     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     输出：7 -> 0 -> 8
 *     原因：342 + 465 = 807
 * </pre>
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/13 11:07
 */
public class Code2 {

    public static void append(StringBuilder sb, ListNode node) {
        sb.append(node.val);
        if(node.next != null) {
            append(sb, node.next);
        }
    }

    public static ListNode reverseArrayToListNode(char[] chars) {
        List<ListNode> nodes = new LinkedList<ListNode>();
        // 生成节点列表
        for(int i = chars.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.parseInt(chars[i] + ""));
            nodes.add(node);
        }
        // 链接节点
        int index = 0;
        while(index < nodes.size() -1) {
            nodes.get(index).next = nodes.get(index + 1);
            index++;
        }

        return nodes.get(0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        // 遍历节点
        append(sb1, l1);
        append(sb2, l2);
        // 反转节点
        int num1 = Integer.parseInt(sb1.reverse().toString());
        int num2 = Integer.parseInt(sb2.reverse().toString());
        // 计算结果
        String sumStr = String.valueOf(num1 + num2);
        char[] chars = sumStr.toCharArray();
        // 转换数组为节点类型
        return reverseArrayToListNode(chars);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        l1.next = l12;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l22.next = l23;
        l2.next = l22;

        ListNode listNode = addTwoNumbers(l1, l2);

        StringBuilder sb = new StringBuilder();
        append(sb, listNode);
        System.out.println(sb.toString());
    }
}
