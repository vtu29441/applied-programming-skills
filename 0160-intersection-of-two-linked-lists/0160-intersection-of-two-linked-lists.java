public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Traverse both lists. When reaching the end of a list, redirect to the head of the other list.
        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // Returns the intersection node or null if there is no intersection
        return ptrA;
    }
}