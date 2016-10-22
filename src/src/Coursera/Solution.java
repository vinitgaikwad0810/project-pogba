package Coursera;

/**
 * Created by vinitanilgaikwad on 9/25/16.
 */
public class Solution {

    static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {


        int maximumProfit = 0, maximum = Integer.MIN_VALUE, previousMaximum = 1;

        for (int i = 0; i < lengths.length; i++)
            if (maximum < lengths[i]) {
                previousMaximum = maximum;
                maximum = lengths[i];
            }
        for (int size = previousMaximum; size <= maximum; size++) {
            int profit = 0;
            for (int i = 0; i < lengths.length; i++) {
                if (size > lengths[i])
                    continue;
                int currPrice = (lengths[i] / size) * metal_price * size;
                int cuts = lengths[i] % size == 0 ? (lengths[i] / size) - 1 : (lengths[i] / size);
                int currProfit = currPrice - cost_per_cut * cuts;
                if (currProfit > 0)
                    profit += currProfit;
            }
            if (profit > maximumProfit)
                maximumProfit = profit;
        }

        return maximumProfit;


    }

    static int numOfPlaylist(int N, int K, int L) {

        if (N == 1 && L != 0 && K == 0) return 1;

        int numOfPlaylist = 0;
        int repetitionThreshold = K;
        for (int i = 0; i < L; i++) {

            if (repetitionThreshold == 0)
                repetitionThreshold = K;

            numOfPlaylist *= repetitionThreshold == 0 ? factorial(N) / factorial(N - 1) : factorial(N - (K - repetitionThreshold)) / factorial(N - (K - repetitionThreshold) - 1);
            repetitionThreshold--;


        }

        return numOfPlaylist;

    }

    static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    public int solution(int X) {

        Long max = Long.MIN_VALUE;

        String number = String.valueOf(X);
        for (int i = 0; i < number.length() - 1; i++) {

            StringBuilder stringBuilder = new StringBuilder(number);

            Long numberOne = (long)Character.getNumericValue(number.charAt(i));
            Long numberTwo = (long)Character.getNumericValue(number.charAt(i + 1));

            Long average = (numberOne + numberTwo + 1) / 2;


            stringBuilder.replace(i, i + 2, String.valueOf(average));

            if (max < Long.parseLong(stringBuilder.toString())) {


                max = Long.parseLong(stringBuilder.toString());

                if(average>numberOne){
                    break;
                }
            }


        }
        return max.intValue();
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.print(solution.solution(623315));
    }
}