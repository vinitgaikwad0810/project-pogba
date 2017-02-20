package _44;

/**
 * Created by vinit on 1/29/17.
 */
public class Solution {

    public boolean isMatch(String s, String p) {

        int sindex = 0, pindex = 0;

        while (true) {

            if (s.length() == sindex && pindex < p.length())
                return false;
            else if (sindex == s.length())
                break;
            else if (pindex >= p.length())
                return false;

            if (s.charAt(sindex) == p.charAt(pindex)) {
                sindex++;
                pindex++;
                continue;
            } else if (p.charAt(pindex) == '?') {

                if (Character.isLetter(s.charAt(sindex))) {
                    sindex++;
                    pindex++;
                    continue;
                } else
                    return false;

            } else if (p.charAt(pindex) == '*') {

                while (pindex + 1 < p.length() && p.charAt(pindex + 1) == '*') {
                    pindex++;
                }


                while (sindex < s.length() && Character.isLetter(s.charAt(sindex))) {

                    sindex++;

                    if (pindex + 1 < p.length() && sindex < s.length() && s.charAt(sindex) == p.charAt(pindex + 1)) {
                        pindex++;
                        break;
                    }
                }

                if (sindex >= s.length() && pindex + 1 == p.length()) {
                    break;
                } else
                    return false;


            } else
                return false;


        }

        return true;

    }
}
