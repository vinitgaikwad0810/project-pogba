package _127;

import java.util.*;

public class Solution {
    class Graph {
        Map<String, LinkedList<String>> list;

        Graph() {

            list = new HashMap<String, LinkedList<String>>();

        }

        void addEdge(String from, String to) {

            if (list.containsKey(from)) {

                if (!list.get(from).contains(to))
                    list.get(from).add(to);

            } else {
                list.put(from, new LinkedList());
                if (!list.get(from).contains(to))
                    list.get(from).add(to);
            }

            if (list.containsKey(to)) {

                if (!list.get(to).contains(from))
                    list.get(to).add(from);

            } else {
                list.put(to, new LinkedList());

                if (!list.get(to).contains(from))
                    list.get(to).add(from);
            }

        }


        int dfs(String from, String to) {

            Queue<String> s = new LinkedList();
            Map<String, Boolean> visited = new HashMap();

            for (Map.Entry<String, LinkedList<String>> entry : list.entrySet()) {

                visited.put(entry.getKey(), false);
            }

            int count = 1;
            s.offer(from);


            visited.put(from, true);


            while (!s.isEmpty()) {
                String curr = s.peek();
                LinkedList<String> curList = list.get(s.poll());

                if (curList == null)
                    return 0;

                if (curList.size() != 0) {
                    for (String word : curList) {

                        visited.put(word, true);
                        if (word.equals(to)) {
                            return count;
                        }


                    }
                    for (String word : curList) {
                        LinkedList<String> tempList = list.get(word);

                        for (String word2 : tempList) {
                            if (!visited.get(word2))
                                s.offer(word2);


                        }
                    }
                }
                count++;
            }

            return 0;
        }
    }


    private int difference(String one, String two) {

        int count = 0;
        for (int i = 0; i < one.length(); i++) {

            if (one.charAt(i) != two.charAt(i))
                count++;
        }

        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Graph g = new Graph();


        for (int i = 0; i < wordList.size(); i++) {

            for (int j = i + 1; j < wordList.size(); j++) {

                if (difference(wordList.get(i), wordList.get(j)) == 1) {

                    g.addEdge(wordList.get(i), wordList.get(j));
                }

            }
        }


        if (wordList.contains(endWord))
            for (int i = 0; i < wordList.size(); i++) {

                if (difference(beginWord, wordList.get(i)) == 1) {
                    g.addEdge(beginWord, wordList.get(i));
                }

                if (difference(endWord, wordList.get(i)) == 1) {
                    g.addEdge(endWord, wordList.get(i));
                }

            }
        else
            return 0;


        return g.dfs(beginWord, endWord);

    }

    public static void main(String[] args) {

//        String beginWord = "teach";
//        String endWord = "place";
//
//        List<String> wordList = Arrays.asList("peale", "wilts", "place", "fetch", "purer", "pooch", "peace", "poach", "berra", "teach", "rheum", "peach");


        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");


        Solution s = new Solution();

        System.out.println(s.ladderLength(beginWord, endWord, wordList));

    }
}




