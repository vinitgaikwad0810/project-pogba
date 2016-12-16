package _3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        Integer max = Integer.MIN_VALUE;
        Integer len = 1;

        if (s.length() == 0)
            return 0;

        if (s.length() == 1)
            return 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.substring(i - len, i).indexOf(s.charAt(i)) == -1) {
                len++;


            } else {


                len = len - s.substring(i - len, i).indexOf(s.charAt(i));
            }

            if (max < len) {
                max = len;
            }
        }

        return max;
    }


}