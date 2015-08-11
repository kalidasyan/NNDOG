package solutions;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    
    int rows = 0;
    int columns = 0;
    List<String> result = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        if(words == null || words.length == 0) return result;
        
        rows = board.length;
        if(rows == 0) return result;
        columns = board[0].length;
        if(columns == 0) return result;
        
        Trie trie = new Trie();
        for(String word : words) {
        	trie.insert(word);
        }
        
        int[][] visited = new int[rows][columns];
        
        for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    dfs(board, i, j, new StringBuffer(), visited, trie);
                }
            }
        
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, StringBuffer word, int[][] visited, Trie trie) {
        if(i < 0 || i >= rows || j < 0 || j >= columns) {
            return;
        }
        
        if(visited[i][j] == 1) {
        	return;
        }
        
        word.append(board[i][j]);
        
        if(trie.startsWith(word.toString())){
            return;
        }
        
        if(trie.search(word.toString())) {
            result.add(word.toString());
        }
        
        visited[i][j] = 1;
        
        dfs(board, i-1, j, word, visited, trie);
        dfs(board, i, j+1, word, visited, trie);
        dfs(board, i+1, j, word, visited, trie);
        dfs(board, i, j-1, word, visited, trie);
        
        visited[i][j] = 0;
        
        word.deleteCharAt(word.length() - 1);
    }
}
