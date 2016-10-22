package _211;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character, TrieNode> map;
    Boolean isEndOfWord;

    // Initialize your data structure here.
    public TrieNode() {
        map = new HashMap();
        isEndOfWord = Boolean.FALSE;

    }
}

public class WordDictionary {
    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {

            Character ch = word.charAt(i);
            if (temp.map.get(ch) != null) {
                temp = temp.map.get(ch);
            } else {
                temp.map.put(ch, new TrieNode());
                temp = temp.map.get(ch);
            }
        }
        temp.isEndOfWord = Boolean.TRUE;

    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode temp = root;


        return search(temp, word, 0);
    }


    public boolean search(TrieNode temp, String word, int index) {

        if (temp == null) {
            return Boolean.FALSE;
        }
        if (index == word.length() && temp.isEndOfWord == Boolean.TRUE) {
            return Boolean.TRUE;
        }
        if (index == word.length() && temp.isEndOfWord == Boolean.FALSE) {
            return Boolean.FALSE;
        }


        char ch = word.charAt(index);

        if (ch == '.') {

            for (Map.Entry<Character, TrieNode> entry : temp.map.entrySet()) {
                temp = entry.getValue();
                if (search(temp, word, index + 1)) return Boolean.TRUE;
            }
        } else {
            return search(temp.map.get(ch), word, index + 1);
        }
        return false;
    }


    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
//        wordDictionary.addWord("and");
//        wordDictionary.addWord("an");
//        wordDictionary.addWord("add");

        System.out.println(wordDictionary.search("."));
    }

}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");