package solutions;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int column = matrix[0].length;
        if(column == 0) return 0;
        
        int[][] result = new int[row][column];
        
        for(int i = 0; i < row; i++) {
        	result[i][0] = matrix[i][0] - '0';
        }
        
        for(int i = 0; i < column; i++) {
        	result[0][i] = matrix[0][i] - '0';
        }
        
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < column; j++) {
        		result[i][j] = (matrix[i][j] == '0') ? 0 : min(result[i-1][j], result[i][j-1], result[i-1][j-1]) + 1;
        	}
        }
        
        int max = 0;
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < column; j++) {
        		if(result[i][j] > max) {
        			max = result[i][j];
        		}
        	}
        }
        
        return max;
    }
    
    private int min(int a, int b, int c) {
    	return Math.min(Math.min(a,b), c);
    }
}
