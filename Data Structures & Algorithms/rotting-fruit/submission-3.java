class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        int[][] ans = new int[n][m];

        for(int i=0; i<n; i++)
        {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }        
            }
        }

        

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int res = 0;

        while(!q.isEmpty())
        {
            int[] a = q.poll();

            int i = a[0];
            int j = a[1];

            int dist = a[2];

            if(dist > ans[i][j])
              continue;

            for(int[] dir : dirs)
            {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x>=0 && x<n && y>=0 && y<m && (grid[x][y] == 1 || grid[x][y] == 2))
                {
                    grid[x][y] = 2;
                    if(ans[x][y] > (dist+1))
                    {
                        ans[x][y] = dist+1;
                        q.offer(new int[]{x, y, dist+1});
                        res = Math.max(res, dist+1);
                    }
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1) 
                   return -1;
            }
        }

        return res;
    }
}
