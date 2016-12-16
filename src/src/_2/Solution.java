package _2;

import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//342
//465
public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb = new StringBuilder();
        BigInteger l1Int = null;
        BigInteger l2Int = null;

        while (l1 != null) {

            sb.append(String.valueOf(l1.val));
            l1 = l1.next;
        }

        l1Int = new BigInteger(sb.toString());

        sb = new StringBuilder();

        while (l2 != null) {

            sb.append(String.valueOf(l2.val));
            l2 = l2.next;
        }
        l2Int = new BigInteger(sb.toString());

        //  System.out.println(l1Int);

        //    System.out.println(l2Int);


        String answer = new StringBuilder(String.valueOf(l1Int.add(l2Int).toString())).reverse().toString();
        //  System.out.println(answer);

        l1 = l2 = new ListNode(Integer.valueOf(String.valueOf(answer.charAt(0))));

        for (int i = 1; i < answer.length(); i++) {

            l1.next = new ListNode(Integer.valueOf(String.valueOf(answer.charAt(i))));

            l1 = l1.next;
        }


        return l2;


    }
}