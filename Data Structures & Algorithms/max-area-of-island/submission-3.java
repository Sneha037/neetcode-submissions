class Solution {
    public int maxAreaOfIsland(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int maxArea = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                   // int count = 0; it doesn't pass by reference
                   int a = dfs(grid, dirs, i, j);
                   maxArea = Math.max(maxArea, a);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int[][] dirs, int i, int j)
    {
        grid[i][j] = 2;

        int count = 1;

        for(int[] dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 1)
            {
                count+= dfs(grid, dirs, x, y);
            }
        }

        return count;
    }
}
