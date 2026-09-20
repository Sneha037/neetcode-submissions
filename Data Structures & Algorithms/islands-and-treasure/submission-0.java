class Solution {
    public void islandsAndTreasure(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int inf = Integer.MAX_VALUE;
        
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty())
        {
            int[] a = q.poll();

            int i = a[0];
            int j = a[1];
            int dist = a[2];

            if(dist < grid[i][j])
               continue;

            for(int[] dir : dirs)
            {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x>=0 && x<m && y>=0 && y<n && grid[x][y] != 0 && grid[x][y] != -1)
                {
                    if(grid[x][y] > (dist+1))
                    {
                        grid[x][y] = dist + 1;
                        q.offer(new int[]{x, y, grid[x][y]});
                    }
                }
            }
        }
    }
}
