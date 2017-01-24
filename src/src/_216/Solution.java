package _216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinit on 1/23/17.
 */
public class Solution {

    static List<List<Integer>> solutionSet = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {


        if(k>n)
            return solutionSet;

        List<Integer> solution = new ArrayList();



        for (int i = 1; i <= 9; i++) {

            if (n - i >= 0) {
                solution.add(i);
                combinationSum3(k, n, new ArrayList<>(solution), 1, i);
                solution.remove(solution.size() - 1);

            } else {


            }



        }

        return solutionSet;

    }

    public void combinationSum3(int k, int n, List<Integer> solution, int currSolutionSize, int currentSum) {


        if (solution.size() == k && n - currentSum == 0) {
            solutionSet.add(solution);
        }


        if (solution.size() < k)
            for (int i = solution.get(solution.size() - 1) + 1; i <= 9; i++) {

                if (n - i >= 0) {

                    solution.add(i);
                    combinationSum3(k, n, new ArrayList<>(solution), currSolutionSize + 1, i + currentSum);
                    solution.remove(solution.size() - 1);

                } else {


                }

            }
    }


    public static void main(String args[]) {

        Solution s = new Solution();
        List<List<Integer>> ans = s.combinationSum3(2, 18);

        System.out.println("Answer " + ans);

    }
}
