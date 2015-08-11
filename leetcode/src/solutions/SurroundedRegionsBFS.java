package solutions;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegionsBFS {
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
        
        List<Coordinate> open = new ArrayList<Coordinate>();
        for(int i = 0; i < row; i++) {
        	if(board[i][0] == 'O'){
        		board[i][0] = 'T';
        		open.add(new Coordinate(i, 0));
        	}
        	
        	if(column > 1 && board[i][column-1] == 'O'){
        		board[i][column-1] = 'T';
        		open.add(new Coordinate(i, column-1));
        	}
        } 
        
        for(int i = 0; i < column; i++) {
        	if(board[0][i] == 'O'){
        		board[0][i] = 'T';
        		open.add(new Coordinate(0, i));
        	}
        	
        	if(row > 1 && board[row-1][i] == 'O'){
        		board[row-1][i] = 'T';
        		open.add(new Coordinate(row-1, i));
        	}
        }
        
        while(!open.isEmpty()){
        	Coordinate c = open.remove(open.size()-1);
        	int x = c.x;
        	int y = c.y;
        	check(x-1, y, board, open);
        	check(x, y+1, board, open);
        	check(x+1, y, board, open);
        	check(x, y-1, board, open);
        }
        
        flip(board);
    }
    
    private void check(int i, int j, char[][] board, List<Coordinate> open) {
    	if(i < 0 || j < 0 || i >= row || j >= column) {
            return;
        }
		
    	if(board[i][j] == 'O') {
    		board[i][j] = 'T';
    		open.add(new Coordinate(i, j));
    	}
	}
    
    private void flip(char[][] board) {
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < column; j++) {
        		if(board[i][j] == 'T'){
        			board[i][j] = 'O';
        		} else {
        			board[i][j] = 'X';
        		}
        	}
        }
    }
    
    public void test() {
//    	char[][] board = {"OOOOOO".toCharArray(), "OXXXXO".toCharArray(), "OXOOXO".toCharArray(), "OXXXXO".toCharArray(), "OOOOOO".toCharArray()};
    	char[][] board = {"XXOX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
    	solve(board);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
