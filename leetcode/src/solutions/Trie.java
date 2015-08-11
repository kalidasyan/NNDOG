package solutions;

class TrieNode {
	TrieNode[] sons;
	int num;
	boolean isEnd;
	char value;
	
    // Initialize your data structure here.
    public TrieNode() {
    	sons = new TrieNode[26];
    	num = 1;
    	isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0) {
        	return;
        }

        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i)-'a';
        	if(node.sons[index] == null) {
        		node.sons[index] = new TrieNode();
        		node.sons[index].value = word.charAt(i);
        	} else {
        		node.sons[index].num++;
        	}
        	node = node.sons[index];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
        	return false;
        }
        
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i)-'a';
        	if(node.sons[index] == null) {
        		return false;
        	} else {
        		node = node.sons[index];
        	}
        	
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
        	return true;
        }
        
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
        	int index = prefix.charAt(i)-'a';
        	if(node.sons[index] == null) {
        		return false;
        	} else {
        		node = node.sons[index];
        	}
        	
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");