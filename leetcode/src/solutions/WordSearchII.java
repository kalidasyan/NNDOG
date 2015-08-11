package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	int rows = 0;
	int columns = 0;
	Set<String> result = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		if (words == null || words.length == 0) {
			return new ArrayList<String>(result);
		}
			
		rows = board.length;
		if (rows == 0)
			return new ArrayList<String>(result);
		columns = board[0].length;
		if (columns == 0)
			return new ArrayList<String>(result);

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int[][] visited = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				dfs(board, i, j, new StringBuffer(), visited, trie);
			}
		}

		return new ArrayList<String>(result);
	}

	private void dfs(char[][] board, int i, int j, StringBuffer word,
			int[][] visited, Trie trie) {
		if (i < 0 || i >= rows || j < 0 || j >= columns) {
			return;
		}

		if (visited[i][j] == 1) {
			return;
		}

		word.append(board[i][j]);

		if (!trie.startsWith(word.toString())) {
			word.deleteCharAt(word.length() - 1);
			return;
		}

		if (trie.search(word.toString())) {
			result.add(word.toString());
		}

		visited[i][j] = 1;

		dfs(board, i - 1, j, word, visited, trie);
		dfs(board, i, j + 1, word, visited, trie);
		dfs(board, i + 1, j, word, visited, trie);
		dfs(board, i, j - 1, word, visited, trie);

		visited[i][j] = 0;

		word.deleteCharAt(word.length() - 1);
	}

	public void test() {
		// char[][] board = new char[][]{"oaan".toCharArray(),
		// "etae".toCharArray(), "ihkr".toCharArray(), "iflv".toCharArray()};
		// String[] words = {"oath","pea","eat","rain"};
		// ["bbaaba","bbabaa","bbbbbb","aaabaa","abaabb"], ["abbbababaa"]
		char[][] board = new char[][] { "baabab".toCharArray(),
				"abaaaa".toCharArray(), "abaaab".toCharArray(),
				"ababba".toCharArray(), "aabbab".toCharArray(),
				"aabbba".toCharArray(), "aabaab".toCharArray() };
		String[] words = { "bbaabaabaaaaabaaba" };

		System.out.println(findWords(board, words));
	}
}
