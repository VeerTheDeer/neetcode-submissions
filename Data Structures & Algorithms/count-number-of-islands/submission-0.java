class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if(grid.length < 1 && grid[0].length < 1) {
            return -1;
        }

        int row = grid.length;
        int column = grid[0].length;
        int islands = 0;
        //starting nested for loop
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length ||
            column >= grid[0].length || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], column + dir[1]);
        }
    }
}
