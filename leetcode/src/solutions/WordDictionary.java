package solutions;

public class WordDictionary {
	
	private DictNode root;
	private static final char DOT = '.';
	
	public WordDictionary(){
		root = new DictNode();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0) {
        	return;
        }
        DictNode node = root;
        for(int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	if(node.sons[index] == null){
        		node.sons[index] = new DictNode();
        		node.sons[index].value = word.charAt(i);
        	} else {
        		node.sons[index].num++;
        	}
        	node = node.sons[index];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	DictNode node = root;
        return searchNode(word, 0, node);
    }
    
    private boolean searchNode(String word, int index, DictNode node) {
    	if(word == null || word.length() == 0) {
        	return false;
        }
    	if(index == word.length()){
    		return node.isEnd;
    	}
    	
    	char c = word.charAt(index);
    	DictNode[] sons = node.sons;
    	if(c == DOT){
    		for(int i = 0; i < sons.length; i++) {
				if(sons[i] != null && searchNode(word, index+1, sons[i])){
					return true;
				}
    		}
    		return false;
    	} else {
    		return (sons[c-'a'] != null && searchNode(word, index+1, sons[c-'a']));
    	}
    }
    
    public void test() {
    	WordDictionary wordDictionary = new WordDictionary();
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

class DictNode{
	public DictNode[] sons;
	int num;
	boolean isEnd;
	char value;
	
	public DictNode(){
		sons = new DictNode[26];
		num = 1;
		isEnd = false;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
