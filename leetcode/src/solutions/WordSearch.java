package solutions;

public class WordSearch {
    
    int rows = 0;
    int columns = 0;
    String word = null;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.trim().length() == 0) return false;
        this.word = word;
        rows = board.length;
        if(rows == 0) return false;
        columns = board[0].length;
        if(columns == 0) return false;
        
        int[][] visited = new int[rows][columns];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(bfs(board, i, j, 0, visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean bfs(char[][] board, int i, int j, int position, int[][] visited) {
        if(i < 0 || i >= rows || j < 0 || j >= columns) {
            return false;
        }
        
        if(visited[i][j] == 1 || board[i][j] != word.charAt(position)){
            return false;
        }
        
        if(position + 1 == word.length()) {
            return true;
        }
        
        position++;
        visited[i][j] = 1;
        
        boolean result = bfs(board, i-1, j, position, visited) || bfs(board, i, j+1, position, visited) || bfs(board, i+1, j, position, visited) || bfs(board, i, j-1, position, visited);
        
        visited[i][j] = 0;
        
        return result;
    }
    
    public void test() {
    	char[][] board = new char[][]{"ab".toCharArray()};
    	exist(board, "ba");
    }
}
