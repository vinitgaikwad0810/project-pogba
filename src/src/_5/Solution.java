package _5;

public class Solution {
    public static String longestPalindrome(String s) {

        int[][] cache = new int[s.length()][s.length()];

        for(int i=0 ; i <s.length(); i++)
        {

            cache[i][i] = 1;
        }

        Integer max = Integer.MIN_VALUE;
        Integer start = 0, end=0;
        Boolean found = false;

        for(int step = 1; step <s.length(); step ++){

            for (int i=0 ; i<s.length()-step; i++){

                if(i+1 == i+step && s.charAt(i) == s.charAt(i+step) ){

                    cache[i][i+step]=1;
                    found = true;


                }else if(cache[i+1][i+step-1] == 1 && s.charAt(i) == s.charAt(i+step)){

                    cache[i][i+step] = 1;
                    found = true;


                }


                if(found && max < step +1){


                    max = step+1;
                    start = i;
                    end = i+step;
                    found = false;

                }else if(found)
                    found = false;






            }


        }
        System.out.println(start);
        System.out.println(end);

        return s.substring(start,end+1);
    }


    public static void main(String args[]){

        System.out.println(longestPalindrome("babad"));
    }

}