package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WordSearchBackTracing{
    class Coordinates{
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinates other = (Coordinates) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    }
    
    int rows = 0;
    int columns = 0;
    
    public boolean exist(char[][] board, String word) {
        if(word.trim().length() == 0) {
            return true;
        }
        
        rows = board.length;
        if(rows == 0) return false;
        columns = board[0].length;
        if(columns == 0) return false;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == word.charAt(0) && search(board, word, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int i, int j) {
    	HashMap<Coordinates, HashSet<Coordinates>> visited = new HashMap<Coordinates, HashSet<Coordinates>>();
    	
        ArrayList<Coordinates> path = new ArrayList<Coordinates>();
        
        path.add(new Coordinates(i, j));
        
        int[][] states = new int[rows][columns];
        states[i][j] = 1;
        
        int position = 1;
        Coordinates current = null;
        
        while(true) {
            if(position == word.length()){
                return true;
            }
            current = path.get(path.size() - 1);
            
            if(checkAvailability(states, i-1, j, visited, current) && board[i-1][j] == word.charAt(position)){
                path.add(new Coordinates(i-1, j));
                states[i-1][j] = 1;
                i = i - 1;
                position++;
            } else if(checkAvailability(states, i, j + 1, visited, current) && board[i][j + 1] == word.charAt(position)){
                path.add(new Coordinates(i, j + 1));
                states[i][j + 1] = 1;
                j = j + 1;
                position++;
            } else if(checkAvailability(states, i + 1, j, visited, current) && board[i + 1][j] == word.charAt(position)){
                path.add(new Coordinates(i + 1, j));
                states[i + 1][j] = 1;
                i = i + 1;
                position++;
            } else if(checkAvailability(states, i, j - 1, visited, current) && board[i][j - 1] == word.charAt(position)){
                path.add(new Coordinates(i, j - 1));
                states[i][j - 1] = 1;
                j = j - 1;
                position++;
            } else {
                if(path.size() == 1) {
                    return false;
                }
                
                Coordinates last = path.remove(path.size() - 1);
                reset(last, visited, states);
                
                //backtrace
                current = path.get(path.size() - 1);
                set(visited, current, last);
                i = current.x;
                j = current.y;
                position--;
            }
        }
    }
    
    private void reset(Coordinates last,
			HashMap<Coordinates, HashSet<Coordinates>> visited, int[][] states) {
		if(visited.containsKey(last)) {
			visited.remove(last);
		}
		states[last.x][last.y] = 0;
	}

	private void set(HashMap<Coordinates, HashSet<Coordinates>> visited,
			Coordinates current, Coordinates last) {
		if(!visited.containsKey(current)) {
			visited.put(current, new HashSet<Coordinates>());
		}
		HashSet<Coordinates> set = visited.get(current);
		set.add(last);
		
	}


	private boolean checkAvailability(int[][] states, int i, int j, HashMap<Coordinates, HashSet<Coordinates>> visited, Coordinates current) {
        if(!checkBoarder(i, j) || (states[i][j] == 1)){
        	return false;
        }
        
        if(visited.containsKey(current)) {
        	HashSet<Coordinates> set = visited.get(current);
        	if(set.contains(new Coordinates(i, j))){
        		return false;
        	}
        }
        
        return true;
    }
    
    private boolean checkBoarder(int i, int j) {
        if(i < 0 || i >= rows) {
            return false;
        }
        
        if(j < 0 || j >= columns) {
            return false;
        }
        
        return true;
    }
    
    public void test() {
    	char[][] board = new char[][]{"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()};
    	System.out.println(exist(board, "ABCEFSADEESE"));
    }
}
