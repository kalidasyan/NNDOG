package solutions;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row-1][column-1]) {
            return false;
        }
        
        return search(matrix, target, 0, row-1, 0, column-1);
    }
    
    private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int columnStart, int columnEnd) {
    	if(rowStart > rowEnd || columnStart > columnEnd || rowStart < 0 || rowEnd > matrix.length - 1 || columnStart < 0 || columnEnd > matrix[0].length - 1) {
    		return false;
    	}
    	
        if(rowStart + 1 < rowEnd || columnStart + 1 < columnEnd) {
        	int rowMiddle = (rowStart + rowEnd) / 2;
        	int columnMiddle = (columnStart + columnEnd) / 2;
        	if(target < matrix[rowMiddle][columnMiddle]) {
        		return search(matrix, target, rowStart, rowMiddle, columnStart, columnMiddle) ||
        				search(matrix, target, rowMiddle + 1, rowEnd, columnStart, columnMiddle - 1) ||
        				search(matrix, target, rowStart, rowMiddle - 1, columnMiddle + 1, columnEnd);
        	} else if (target > matrix[rowMiddle][columnMiddle]) {
        		return search(matrix, target, rowMiddle, rowEnd, columnMiddle, columnEnd) ||
        				search(matrix, target, rowMiddle + 1, rowEnd, columnStart, columnMiddle - 1) ||
        				search(matrix, target, rowStart, rowMiddle - 1, columnMiddle + 1, columnEnd);
        	} else {
        		return true;
        	}
        } else {
        	return (matrix[rowStart][columnStart] == target) || 
            		(matrix[rowEnd][columnStart] == target) || 
            		(matrix[rowStart][columnEnd] == target) || 
            		(matrix[rowEnd][columnEnd] == target);
        }
    }
    
    public void test() {
    	int[][] matrix = new int[][]{{1,3,5}};
    	int target = 2;
    	System.out.println(searchMatrix(matrix, target));
    }
}
