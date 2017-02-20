package _21;

/**
 * Created by vinit on 2/11/17.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null, temp = null;

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;


        if (l1.val < l2.val) {

            head = l1;
            l1 = l1.next;

        } else {
            head = l2;
            l2 = l2.next;


        }

        ListNode return2 = head;
        while (l1 != null && l2 != null) {


            if (l1.val < l2.val) {

                temp = l1;
                l1 = l1.next;


            } else {
                temp = l2;
                l1 = l2.next;


            }


            head.next = temp;
            head = head.next;
        }

        if (l1 != null)
            head.next = l1;


        if (l2 != null)
            head.next = l2;


        return return2;

    }

    public static void main(String[] args) {

        String s;

        ListNode head5 = new ListNode(5);
        ListNode head1 = new ListNode(1);

        ListNode head2 = new ListNode(2);
        ListNode head4 = new ListNode(4);

        head1.next = head2;
        head2.next = head4;
        head4.next = null;

        Solution s1 = new Solution();
        ListNode temp = s1.mergeTwoLists(head5, head1);

        while (temp != null) {
            System.out.println(temp.val);

            temp = temp.next;
        }


    }
}
