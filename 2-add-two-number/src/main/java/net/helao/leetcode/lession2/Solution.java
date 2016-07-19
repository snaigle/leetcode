package net.helao.leetcode.lession2;

/**
 * Created by wangcheng<gates@mucang.cn> on 16/7/19.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        internalAdd(root, l1, l2, 0);
        return root.next;
    }

    private ListNode internalAdd(ListNode parent, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return parent;
        }
        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        int sum = v1 + v2 + carry;
        int v = sum % 10;
        int nextCarry = sum / 10;
        ListNode node = new ListNode(v);
        parent.next = node;
        return internalAdd(node, l1 == null ? null : l1.next, l2 == null ? null : l2.next, nextCarry);
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(2, 9, 9);
        ListNode l2 = createListNode(8, 0, 0, 9, 9, 9, 9, 9);
        Solution s = new Solution();
        ListNode result = s.addTwoNumbers(l1, l2);
        ListNode it = result;
        while (it != null) {
            System.out.println(it.val);
            it = it.next;
        }
    }

    private static ListNode createListNode(int... args) {
        ListNode root = null;
        ListNode node = null;
        for (int n : args) {
            if (node == null) {
                node = new ListNode(n);
                root = node;
            } else {
                node.next = new ListNode(n);
                node = node.next;
            }
        }
        return root;
    }
}
