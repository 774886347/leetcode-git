package day0807;

/**
 * @author chensimian
 */
public class LeetCode160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }

    public ListNode solution2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        // 1.让二者分别走到链表末尾，测出各自长度
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            pA = pA.next;
            ++lenA;
        }
        while (pB != null) {
            pB = pB.next;
            ++lenB;
        }
        pA = headA;
        pB = headB;
        // 2.得到分别链长的差值，让长的先走这个差值
        int diff = lenA - lenB;
        if (diff > 0) {
            int step = diff;
            while (step > 0) {
                pA = pA.next;
                --step;
            }
        } else if (diff < 0) {
            int step = diff;
            while (step < 0) {
                pB = pB.next;
                ++step;
            }
        }
        // 3.两指针往前走，相遇即为所求
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
