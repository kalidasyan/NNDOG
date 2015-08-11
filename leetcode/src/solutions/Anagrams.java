package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
    	List<String> result = new ArrayList<String>();
    	if(strs == null || strs.length == 0) {
    		return result;
    	}
    	//record empty strings ""
    	List<Integer> emptyStrs = new ArrayList<Integer>();
    	
    	Trie2 trie = new Trie2();
    	for(int i = 0; i < strs.length; i++) {
    		String s = strs[i];
    		if(s.length() == 0) {
    			emptyStrs.add(i);
    		} else {
    			trie.insert(sortString(s), i);
    		}
    	}
    	
    	List<Integer> indexes = trie.getAnagrams();
    	for(Integer index : indexes) {
    		result.add(strs[index]);
    	}
    	
    	//Add empty strings if there are more than two of them
    	if(emptyStrs.size() > 1) {
        	for(Integer index : emptyStrs) {
        		result.add(strs[index]);
        	}
    	}
    	
    	return result;
    }
    
    private String sortString(String s){
    	if(s == null || s.length() == 0) {
    		return s;
    	}
    	int[] counts = new int[26];
    	for(int i = 0; i < s.length(); i++) {
    		counts[s.charAt(i) - 'a']++;
    	}
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i = 0; i < 26; i++) {
    		int count = counts[i];
    		char c = (char)('a' + i);
    		for(int j = 0; j < count; j++) {
    			sb.append(c);
    		}
    	}
    	return sb.toString();
    }
    
	public void test() {
		String[] strs = new String[]{"abcd", "acbd", "abdc", "aab", "baa", "ccc", "aaa"};
		List<String> result = this.anagrams(strs);
		for(String s : result) {
			System.out.println(s + ", ");
		}
		
	}
}



class Trie2 {
	class TrieNode {
		HashMap<Character, TrieNode> sons;
		int num;
		boolean isEnd;
		char value;
		List<Integer> wordIndexes;
		
	    // Initialize your data structure here.
	    public TrieNode() {
	    	sons = new HashMap<Character, TrieNode>();
	    	num = 0;
	    	isEnd = false;
	    }
	    
	    public void addWord(int index) {
	    	if(wordIndexes == null) {
	    		wordIndexes = new ArrayList<Integer>();
	    	}
	    	wordIndexes.add(index);
	    }
	    
	    public int getNumWords(){
	    	if(wordIndexes == null) {
	    		return 0;
	    	} else {
	    		return wordIndexes.size();
	    	}
	    }
	    
	    public List<Integer> getWords() {
	    	return wordIndexes;
	    }
	}
	
    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word, int index) {
        if(word == null || word.length() == 0) {
        	return;
        }

        TrieNode node = root;
        root.num++;
        for(int i = 0; i < word.length(); i++) {
        	char val = word.charAt(i);
        	if(!node.sons.containsKey(val)) {
        		node.sons.put(word.charAt(i), new TrieNode());
        	}
        	
        	TrieNode son = node.sons.get(val);
        	son.num++;
        	node = son;
        }
        node.isEnd = true;
        node.addWord(index);
    }
    
    public List<Integer> getAnagrams() {
    	List<Integer> indexes = new ArrayList<Integer>();
    	searchAnagrams(indexes, root);
    	return indexes;
    }

	private void searchAnagrams(List<Integer> result, TrieNode node) {
		if(node.isEnd && node.getNumWords() > 1) {
			result.addAll(node.getWords());
		}
		
		if(node.num < 2) {
			return;
		}
		
		for(TrieNode son : node.sons.values()) {
			searchAnagrams(result, son);
		}
	}
}