import java.util.*;

class DFS {
    public int numIslands(char[][] grid) {
        // edge case
        if (grid.length < 0)
            return -1;
        int ans = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    dfsIslands(grid, r, c);
                }
            }
        }
        return ans;
    }

    private void dfsIslands(char[][] grid, int r, int c) {
        // edge case: if the visit point is out of bounded or not a island
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1')
            return;

        // marked this island has visited;
        grid[r][c] = '*';

        dfsIslands(grid, r, c + 1);
        dfsIslands(grid, r, c - 1);
        dfsIslands(grid, r + 1, c);
        dfsIslands(grid, r - 1, c);
    }

    public boolean wordSearch(char[][] board, String word) {
        // edge case
        if (board.length < 0 || word.length() < 0)
            return false;

        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (wordSearchHelper(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean wordSearchHelper(char[][] board, int i, int j, String w, int index) {
        // base case
        if (index == w.length())
            return true;

        // edge case
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || w.charAt(index) != board[i][j])
            return false;

        char c = board[i][j];
        // mark as visited
        board[i][j] = '*';
        boolean visited = wordSearchHelper(board, i + 1, j, w, index + 1) || wordSearchHelper(board, i - 1, j, w, index + 1)
                || wordSearchHelper(board, i, j - 1, w, index + 1) || wordSearchHelper(board, i, j + 1, w, index + 1);
        // recovery the grid for other search
        board[i][j] = c;
        return visited;
    }
}