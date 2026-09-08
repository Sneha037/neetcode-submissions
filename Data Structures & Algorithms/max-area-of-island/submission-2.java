class Solution {
    public int maxAreaOfIsland(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int area = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    int a = dfs(grid, dirs, i, j);
                    area = Math.max(area, a);
                }
            }
        }

        return area;
    }

    public int dfs(int[][] grid, int[][] dirs, int i, int j)
    {
        grid[i][j] = 2;
        int count = 0;
        for(int[] dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];

            if(isValid(x, y, grid) && grid[x][y] == 1)
            {
                count+= dfs(grid, dirs, x, y);
            }
        } 
        return count+1;
    }

    public boolean isValid(int x, int y, int[][] grid)
    {
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length)
        {
            return true;
        }

        return false;
    }
}
