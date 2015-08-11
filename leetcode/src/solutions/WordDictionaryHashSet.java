package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordDictionaryHashSet {
	Set<String> dict = new HashSet<String>();
	Set<Integer> length = new HashSet<Integer>();
	private static final char DOT = '.';
    // Adds a word into the data structure.
    public void addWord(String word) {
        dict.add(word);
        length.add(word.length());
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if(!length.contains(word.length())) {
    		return false;
    	}
    	
    	if(word.indexOf(DOT) == -1) {
    		return dict.contains(word);
    	}
    	
        List<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < word.length(); i++) {
        	if(word.charAt(i) == DOT){
        		indexes.add(i);
        	}
        }
        
        StringBuffer sb = new StringBuffer(word);
        return dfsSearch(sb, indexes, indexes.size());
    }
    
    private boolean dfsSearch(StringBuffer word, List<Integer> indexes, int numDots) {
    	if(numDots == 0) {
    		return dict.contains(word.toString());
    	}
    	
    	for(int i = 0; i < 26; i++) {
    		word.setCharAt(indexes.get(numDots-1), (char)('a' + i));
    		if(dfsSearch(word, indexes, numDots-1)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    public void test() {
    	WordDictionaryHashSet wordDictionary = new WordDictionaryHashSet();
    	wordDictionary.addWord("bad");
    	wordDictionary.addWord("dad");
    	wordDictionary.addWord("mad");
    	//
    	System.out.println(wordDictionary.search("pad"));
    	System.out.println(wordDictionary.search("bad"));
    	System.out.println(wordDictionary.search(".ad"));
    	System.out.println(wordDictionary.search("b.."));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");


