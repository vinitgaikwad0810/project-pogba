package _279;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinit on 1/23/17.
 */
public class Solution {

    static int solutionSize = Integer.MAX_VALUE;

    public int numSquares(int n) {

        List<Integer> solutionSet = new ArrayList();
        //Integer solutionSize = 0;


        List<Integer> solution = new ArrayList();

        for (int i = 1; i * i <= n; i++) {

            if (n - i * i >= 0) {


                solution.add(i * i);

                helper(n, new ArrayList<Integer>(solution), n - i * i);

                solution.remove(solution.size() - 1);

            }

        }


        return solutionSize;

    }

    public void helper(int n, List<Integer> solution, int target) {

        if (target == 0 && solutionSize > solution.size()) {

            solutionSize = solution.size();
        }

        if (target < 0)
            return;

        for (int i = 1; i * i <= target; i++) {

            if (target - i * i >= 0) {


                solution.add(i * i);

                helper(n, new ArrayList<Integer>(solution), target - i * i);

                solution.remove(solution.size() - 1);

            }

        }

    }


    public static void main(String args[]) {

        Solution s = new Solution();
        System.out.println(s.numSquares(45));

    }
}
