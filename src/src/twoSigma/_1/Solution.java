package twoSigma._1;

import java.util.*;

/**
 * Created by vinit on 2/5/17.
 */
public class Solution {

    static int friendCircles(String[] friends) {

        Queue<Integer> q;
        boolean[] visited = new boolean[friends.length];
        int count = 0;

        for (int i = 0; i < friends.length; i++) {

            if (visited[i] == Boolean.TRUE) {
                continue;

            }
            count++;
            q = new LinkedList<>();
            q.offer(i);

            while (!q.isEmpty()) {
                Integer curVertex = q.poll();
                for (int j = 0; j < friends[curVertex].length(); j++) {

                    if (friends[curVertex].charAt(j) == 'Y') {
                        if (!visited[friends[curVertex].charAt(j)]) {
                            q.offer(j);
                            visited[j] = Boolean.TRUE;

                        }
                    }
                }

            }


        }

        return count;


    }


    static int longestChain(String[] words) {
        Map<String, Integer> cache = new HashMap<>();
        int longestChain = Integer.MIN_VALUE;


        if (words.length == 1) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        for (int i = 0; i < words.length; i++) {

            int curLength = 0;
            if (words[i] == null && words[i].length() == 0) {
                curLength = 0;

            } else if (words[i].length() == 1) {
                cache.put(words[i], 1);
                curLength = 1;

            } else {
                curLength = 0;
                for (int j = 0; j < words[i].length(); j++) {

                    // String subString = words[i].substring(0, j) + words[i].substring(j + 1, words[i].length());

                    StringBuilder s = new StringBuilder(words[i]);
                    s = s.deleteCharAt(j);
                    String subString = s.toString();
                    if (cache.containsKey(subString)) {


                        if (curLength < cache.get(subString) + 1)
                            curLength = cache.get(subString) + 1;
                    }


                }

            }
            cache.put(words[i], curLength);

            longestChain = Math.max(curLength, longestChain);

        }


        return longestChain;
    }

    static int longest_chain(String[] words) {
        HashSet<String> dict = new HashSet<String>();

        // remeber the word and its relative longest chain.
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 1; i < words.length; i++) {
            dict.add(words[i]);
        }

        int longest = 0;

        for (int i = 1; i < words.length; i++) {
            int len = helper(words[i], dict, map) + 1;
            map.put(words[i], len);
            longest = Math.max(longest, len);

        }

        return longest;

    }

    static int helper(String word, HashSet<String> dict, HashMap<String, Integer> map) {

        for (int i = 0; i < word.length(); i++) {
            StringBuilder s = new StringBuilder(word);
            s = s.deleteCharAt(i);
            String newWord = s.toString();
            if (dict.contains(newWord)) {
                if (map.containsKey(newWord))
                    return map.get(newWord);
                return helper(newWord, dict, map) + 1;
            }


        }
        return 0;
    }
}
