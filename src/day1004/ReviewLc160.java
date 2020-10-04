package day1004;

public class ReviewLc160 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        ListNode nodeA3 = new ListNode(8);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(0);
        ListNode nodeB3 = new ListNode(1);
        ListNode nodeB4 = nodeA3;
        ListNode nodeB5 = nodeA4;
        ListNode nodeB6 = nodeA5;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeA3;
        nodeB4.next = nodeA4;
        nodeB5.next = nodeA5;
        //listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
        System.out.println(new ReviewLc160().getIntersectionNode(nodeA1, nodeB1).toString());
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA!=pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
