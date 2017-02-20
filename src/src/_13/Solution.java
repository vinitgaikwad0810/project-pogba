package _13;

/**
 * Created by vinit on 1/24/17.
 */
public class Solution {

    public int romanToInt(String s) {

        Integer sum = romanToInt(s.charAt(0));

        char prev = s.charAt(0);

        if (s.length() == 1)
            return sum;


        for (int i = 1; i < s.length(); i++) {

            if (romanToInt(prev) < romanToInt(s.charAt(i))) {

                sum = sum - romanToInt(prev) * 2;
                sum = sum + romanToInt(s.charAt(i));
            } else {
                sum = sum + romanToInt(s.charAt(i));
            }

            prev = s.charAt(i);

        }

        return sum;

    }


    public int romanToInt(char s) {

        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;

        }
    }
}
