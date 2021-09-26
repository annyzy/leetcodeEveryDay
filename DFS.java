import java.util.*;

class DFS {
    public int numIslands(char[][] grid) {
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
        // base case: if the visit point is out of bounded or not a island
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1')
            return;

        // marked this island has visited;
        grid[r][c] = '*';

        dfsIslands(grid, r, c + 1);
        dfsIslands(grid, r, c - 1);
        dfsIslands(grid, r + 1, c);
        dfsIslands(grid, r - 1, c);
    }
}