package solutions;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        //rows
        for(int i = 0; i < 9; i++) {
            if(isValidRow(board[i]) == false) {
                return false;
            }
        }
        
        char[] row = new char[9];
        //columns
        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                row[i] = board[i][j];
            }
            if(isValidRow(row) == false) {
                return false;
            }
        }
        
        /*
        for(int i = 0; i < 9; i++) {
            row[i] = board[i][i];
        }
        if(isValidRow(row) == false) {
            return false;
        }
        
        for(int i = 0; i < 9; i++) {
            row[i] = board[i][8-i];
        }
        if(isValidRow(row) == false) {
            return false;
        }
        */
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                row[0] = board[3*i][3*j];
                row[1] = board[3*i][3*j + 1];
                row[2] = board[3*i][3*j + 2];
                
                row[3] = board[3*i + 1][3*j];
                row[4] = board[3*i + 1][3*j + 1];
                row[5] = board[3*i + 1][3*j + 2];
                
                row[6] = board[3*i + 2][3*j];
                row[7] = board[3*i + 2][3*j + 1];
                row[8] = board[3*i + 2][3*j + 2];
                
                if(isValidRow(row) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[] row) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < 9; i ++) {
            if(row[i] == '.') continue;
            if(row[i] < '1' || row[i] > '9' || set.contains(row[i])) {
                return false;
            } else {
                set.add(row[i]);
            }
        }
        return true;
    }
    
    public void test() {
    	char[][] board = {
    			"..4...63.".toCharArray(),
    			".........".toCharArray(),
    			"5......9.".toCharArray(),
    			"...56....".toCharArray(),
    			"4.3.....1".toCharArray(),
    			"...7.....".toCharArray(), 
    			"...5.....".toCharArray(),
    			".........".toCharArray(),
    			".........".toCharArray()
    			};
    	isValidSudoku(board);
    }
    
    public void test2() {
    	char[][] board = {
    			"........2".toCharArray(),
    			"......6..".toCharArray(),
    			"..14..8..".toCharArray(),
    			".........".toCharArray(),
    			".........".toCharArray(),
    			"....3....".toCharArray(), 
    			"5.86.....".toCharArray(),
    			".9....4..".toCharArray(),
    			"....5....".toCharArray()
    			};
    	isValidSudoku(board);
    }
}
