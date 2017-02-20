package _126;

import java.util.*;

/**
 * Created by vinit on 2/18/17.
 */
public class Solution {


    class WordCompare {

        String s1;
        String s2;

        public WordCompare(String s1, String s2) {

            this.s1 = s1;
            this.s2 = s2;
        }


        public int hashCode() {

            String str = s1 + s2;
            return str.hashCode();
        }

        public boolean equals(WordCompare other) {

            if (s1.equals(s1) && s2.equals(s2))
                return true;

            return false;


        }

    }

    public Map<WordCompare, Boolean> m = new HashMap();


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new LinkedList();

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        //  Iterator<String> it = wordList.iterator();

        for (int i = 0; i < wordList.size(); i++) {

            String word = wordList.get(i);

            if (isDiffOne(word, beginWord)) {

                List<String> curr = new LinkedList();
                curr.add(beginWord);
                curr.add(word);
                wordList.remove(i);
                findLadders(beginWord, endWord, wordList, curr, ans, min);
                wordList.add(word);
            }

        }
        return ans;
    }


    private boolean isDiffOne(String s1, String s2) {

        WordCompare wc = new WordCompare(s1, s2);

        if (m.containsKey(wc))
            return m.get(wc);


        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i))
                count++;

            if (count > 1) {
                m.put(wc, false);
                return false;
            }

        }

        m.put(wc, true);
        return true;
    }

    private void findLadders(String beginWord, String endWord, List<String> wordList, List<String> curr, List<List<String>> ans, int[] min) {

        if (curr.get(curr.size() - 1).equals(endWord)) {
            if (curr.size() == min[0] || min[0] == Integer.MAX_VALUE) {
                ans.add(curr);
                min[0] = curr.size();


            } else if (curr.size() < min[0]) {

                ans.clear();
                ans.add(curr);
                min[0] = curr.size();
            }
        }


        for (int i = 0; i < wordList.size(); i++) {

            String word = wordList.get(i);

            if (isDiffOne(word, curr.get(curr.size() - 1))) {

                List<String> currNew = new LinkedList();
                currNew.addAll(curr);
                currNew.add(word);
                wordList.remove(i);
                findLadders(beginWord, endWord, wordList, currNew, ans, min);
                wordList.add(word);
            }

        }
    }


    public static void main(String[] args) {

        System.out.println(new Solution().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }


//    "hit"
//            "cog"
//            ["hot","dot","dog","lot","log","cog"]
}