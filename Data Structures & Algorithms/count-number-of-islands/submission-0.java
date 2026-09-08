class Solution {
    public int numIslands(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int count = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, dirs, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int[][] dirs, int i, int j)
    {
        grid[i][j] = 2;

        for(int[] dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];

            if(isValid(grid, x, y) && grid[x][y] == '1')
            {
                dfs(grid, dirs, x, y);
            }
        }
    }

    public boolean isValid(char[][] grid, int i, int j)
    {
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length)
        {
            return true;
        }

        return false;
    }
}
