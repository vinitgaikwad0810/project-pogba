package _137;

public class Solution {
    public int singleNumber(int[] nums) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            n1 = (n1 & ~nums[i]) | (~n1 & ~n2 & nums[i]);
            n2 = (n2 & ~nums[i]) | (~n1 & ~n2 & nums[i]);
        }
        return n1;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{0, -1, 5, 0, -1, 0, -1};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
}