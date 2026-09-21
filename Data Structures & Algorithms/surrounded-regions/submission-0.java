class Solution {
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;

        char[][] ans = new char[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                ans[i][j] = board[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int j=0; j<n; j++)
        {
            if(ans[0][j] == 'O')
            {
                ans[0][j] = 'M';
                q.offer(new int[]{0, j});
            }

            if(ans[m-1][j] == 'O')
            {
                ans[m-1][j] = 'M';
                q.offer(new int[]{m-1, j});
            }
        }

        for(int i=1; i<m-1; i++)
        {
            if(ans[i][0] == 'O')
            {
                ans[i][0] = 'M';
                q.offer(new int[]{i, 0});
            }

            if(ans[i][n-1] == 'O')
            {
                ans[i][n-1] = 'M';
                q.offer(new int[]{i, n-1});
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty())
        {
            int[] a = q.poll();

            int i = a[0];
            int j = a[1];
            
            /*int dist = a[2];

            if(dist > 0)
              continue;
            */

            for(int[] dir : dirs)
            {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x>=0 && x<m && y>=0 && y<n && ans[x][y] == 'O')
                {
                    ans[x][y] = 'M';
                    q.offer(new int[]{x, y});
                }
            }
        }

       for(int i=0; i<m; i++)
       {
          for(int j=0; j<n; j++)
          {
             if(board[i][j] == 'O' && ans[i][j] == 'O')
             {
                board[i][j] = 'X';
             }
          }
       }
    }
}
