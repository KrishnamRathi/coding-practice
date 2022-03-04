import java.util.*;

// REFER QUE: - https://leetcode.com/problems/design-add-and-search-words-data-structure/

class Trie{
    char data;
    int end;
    HashMap<Character, Trie> h;
    Trie(char data, int we){
        this.data = data;
        this.end = we;
        h=new HashMap<>();
    }
}

class WordDictionary {

    /** Initialize your data structure here. */
    Trie root;
    public WordDictionary() {
        this.root = new Trie('/', 0);
    }
    
    public void addWord(String word) {
        int n = word.length();
        Trie temp = root;
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if(!temp.h.containsKey(c)) temp.h.put(c, new Trie(c, 0));
            temp = temp.h.get(c);
        }
        temp.end++;
    }
    
    public boolean solve(String word, Trie node){
        int n=word.length();
        if(n==0) return node.end>0;
        
        boolean ans= false;
        char c = word.charAt(0);
        if(c=='.'){
            for(Map.Entry<Character, Trie> es: node.h.entrySet()){
                if(n==1 && es.getValue().end>0) return true; 
                ans = solve(word.substring(1, n), es.getValue());
                if(ans) return ans;
            }
        }else{

            if(!node.h.containsKey(c)) return false;
            else {
                ans =  solve(word.substring(1, n), node.h.get(c));
            }

        }
        
        return ans;
    }
    public boolean search(String word) {
        return solve(word, root);
    }
}