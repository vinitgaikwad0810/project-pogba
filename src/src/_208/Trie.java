package _208;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character,TrieNode> map;
    Boolean isEndOfWord;
    // Initialize your data structure here.
    public TrieNode() {
        map = new HashMap();
        isEndOfWord = Boolean.FALSE;

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){

            Character ch = word.charAt(i);

            if(temp.map.get(ch)!=null)
            {
                temp = temp.map.get(ch);
            }else{
                temp.map.put(ch,new TrieNode());
                temp = temp.map.get(ch);
            }
        }
        temp.isEndOfWord = Boolean.TRUE;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        TrieNode temp = root;

        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);

            temp = temp.map.get(ch);
            if(temp==null){
                return false;
            }
        }
        if(temp.isEndOfWord == Boolean.TRUE){
            return true;
        }else{
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0; i<prefix.length(); i++){
            Character ch = prefix.charAt(i);
            temp = temp.map.get(ch);
            if(temp==null){
                return false;
            }
        }
        return true;

    }
}