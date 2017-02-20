package _129;


import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int sumNumbers(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        Integer total = null;

        List<Integer> numbers = new ArrayList();


        if (root.left == null && root.right == null)
            return 0;

        sb.append(String.valueOf(root.val));

        if (root.left != null)
            helper(root.left, sb.toString(), numbers);

        if (root.right != null)
            helper(root.right, sb.toString(), numbers);


        for (Integer number : numbers) {
            total += number;
        }


        return total;

    }

    public void helper(TreeNode root, String prevNumber, List<Integer> numbers) {


        if (root.left == null && root.right == null) {

            StringBuilder sb = new StringBuilder(prevNumber);

            sb.append(String.valueOf(root.val));


            numbers.add(Integer.valueOf(sb.toString()));

        } else {


            if (root.left != null) {

                StringBuilder sbl = new StringBuilder(prevNumber);

                sbl.append(String.valueOf(root.val));

                helper(root.left, sbl.toString(), numbers);
            }

            if (root.right != null) {

                StringBuilder sbr = new StringBuilder(prevNumber);


                sbr.append(String.valueOf(root.val));

                helper(root.right, sbr.toString(), numbers);
            }

        }

    }
}