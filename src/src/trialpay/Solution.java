package trialpay;

import java.util.InputMismatchException;

/**
 * Created by vinit on 12/25/16.
 */
public class Solution {

    static boolean isPermutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        int xorResult = 0;
        for (int i = 0; i < a.length(); i++) {
            xorResult ^= a.charAt(i) ^ b.charAt(i);
        }

        return xorResult == 0;


    }

    class Node {
        int value;
        Node next;
        Node below;

    }

    static int searchNodes(Node root, int value) {

        Integer next = 9999;
        Integer below = 9999;
        if (root.value == value) {
            return 0;
        }
        if (root.next != null) {
            next = searchNodes(root.next, value);
        }
        if (root.below != null) {
            below = searchNodes(root.below, value);
        }

        if (root == null)
            return 9999;


        if (next >= below)
            return 1 + below;
        else
            return 1 + next;
    }


}
