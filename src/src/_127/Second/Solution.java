package _127.Second;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < wordList.size(); i++) {

                    String target = null;
                    if (isDifferenceOne(word, wordList.get(i)))
                        target = wordList.get(i);

                    if (target != null && endSet.contains(target)) {
                        return len + 1;
                    }

                    if (target != null && !visited.contains(target) && wordList.contains(target)) {
                        temp.add(target);
                        visited.add(target);
                    }
                }

            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    private boolean isDifferenceOne(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;

        int count = 0;

        for (int i = 0; i < word1.length(); i++) {

            if (word1.charAt(i) != word2.charAt(i))
                count++;

            if (count > 1)
                return false;
        }

        if (count == 1)
            return true;

        return false;


    }


    public void helper(String beginWord, String endWord, Integer wordToAdd, List<String> wordList, List<String> ans, List<String> curr) {

        if (wordToAdd >= wordList.size())
            return;

        curr.add(wordList.get(wordToAdd));

        if (wordList.get(wordToAdd).equals(endWord)) {
            if (ans.size() == 0 || ans.size() > curr.size()) {
                ans.clear();
                ans.addAll(curr);
                return;
            }
        } else {


            for (int i = wordToAdd; i < wordList.size(); i++) {

                if (isDifferenceOne(wordList.get(wordToAdd), wordList.get(i))) {

                    List<String> curr1 = new LinkedList();
                    curr1.addAll(curr);
                    helper(beginWord, endWord, i, wordList, ans, curr1);

                }

            }


        }


    }

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));


    }
}