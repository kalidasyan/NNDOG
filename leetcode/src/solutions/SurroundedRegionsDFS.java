package solutions;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegionsDFS {
    private class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int row = 0;
    int column = 0;
    
    public void solve(char[][] board) {
        if(board == null) return;
        row = board.length;
        if(row == 0) return;
        column = board[0].length;
        if(column == 0) return;
        
        boolean[][] mark = new boolean[row][column];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                mark[i][j] = (board[i][j] == 'X' ? false : true);
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(mark[i][j]){
                    List<Coordinate> visiting = new ArrayList<Coordinate>();
                    
                    if(dfs(i, j, mark, visiting)) {
                        flip(visiting, board);
                    }
                    visiting.clear();
                }
            }
        }
    }
    
    private boolean dfs(int i, int j, boolean[][] mark, List<Coordinate> visiting) {
        if(i < 0 || j < 0 || i >= row || j >= column) {
            return false;
        }
        
        if(mark[i][j]) {
            mark[i][j] = false;
            visiting.add(new Coordinate(i, j));
            boolean s1 = dfs(i-1, j, mark, visiting);
            boolean s2 = dfs(i, j+1, mark, visiting);
            boolean s3 = dfs(i+1, j, mark, visiting);
            boolean s4 = dfs(i, j-1, mark, visiting);
            return s1 && s2 && s3 && s4;
        } else {
            return true;
        }
    }
    
    private void flip(List<Coordinate> visiting, char[][] board) {
        for(Coordinate c : visiting) {
            board[c.x][c.y] = 'X';
        }
    }
    
    public void test() {
    	char[][] board = {"OOOOOO".toCharArray(), "OXXXXO".toCharArray(), "OXOOXO".toCharArray(), "OXXXXO".toCharArray(), "OOOOOO".toCharArray()};
    	solve(board);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
