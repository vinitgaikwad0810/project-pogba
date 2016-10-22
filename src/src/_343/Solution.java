package _343;

public class Solution {
    public int integerBreak(int n) {


        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            int temp = helper(n - i) * helper(i);

            if (max < temp) {
                max = temp;
            }

        }

        return max;
    }

    public static int helper(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            int temp = helper(n - i) * helper(i);

            if (max < temp) {
                max = temp;
            }

        }
        if (max < n) return n;

        return max;

    }
}