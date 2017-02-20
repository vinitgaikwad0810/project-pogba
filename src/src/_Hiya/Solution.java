package _Hiya;

/**
 * Created by vinit on 2/10/17.
 */

import java.io.*;
import java.util.*;

public class Solution {

    static Map<Integer, List<Integer>> cache = new HashMap<>();

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner ip = new Scanner(System.in);

        //String line = ip.nextLine();
        List<Integer> input = new ArrayList();

        input.add(5);
        input.add(6);
        input.add(0);
        input.add(4);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(0);
        input.add(0);
        input.add(4);


//        while (ip.hasNextLine()) {
//            String line = ip.nextLine();
//
//            input.add(Integer.valueOf(line));
//        }

        Integer hops = input.get(0);
        List<Integer> ans = new ArrayList();

        for (int i = hops; i > 0; i--) {

            List<Integer> curr = new ArrayList<>();
            curr.add(0);
            helper(i, input, ans, curr);

            //System.out.print(input.get(i));


        }


        //System.out.print(ans);
        Iterator<Integer> i = ans.iterator();

        //System.out.println();
        while (i.hasNext()) {
            System.out.print(i.next());
            System.out.print(", ");
        }
        System.out.print("out");

    }


    public static void helper(Integer index, List<Integer> input, List<Integer> ans, List<Integer> curr) {

        if (index >= input.size()) {

            if (ans.size() == 0 || ans.size() > curr.size()) {
                ans.clear();
                ans.addAll(curr);
            }
            return;
        }

        if (input.get(index) == 0) {

            return;
        }

        Integer hops = input.get(index);

        curr.add(index);

        for (int i = hops; i > 0; i--) {


            helper(index + i, input, ans, new ArrayList(curr));

            //System.out.print(input.get(i));


        }

        if(!ans.isEmpty() && ans.contains(index)){
              ans.indexOf(index);

         //   cache.put(index, ans.addAll(ans.indexOf(index)+1));
        }


    }
}
