class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pq1 = new LinkedList<>();
        Queue<int[]> pq2 = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        for(int j=0; j<m; j++)
        {
            pacific[0][j] = true;
            atlantic[n-1][j] = true;

            pq1.offer(new int[]{0, j});
            pq2.offer(new int[]{n-1, j});
        }

        for(int i=0; i<n; i++)
        {
            pacific[i][0] = true;
            atlantic[i][m-1] = true;

            pq1.offer(new int[]{i, 0});
            pq2.offer(new int[]{i, m-1});
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while(!pq1.isEmpty())
        {
            int[] a = pq1.poll();

            int i = a[0];
            int j = a[1];

            for(int[] dir : dirs)
            {
                int x = i + dir[0];
                int y = j + dir[1];
                
                if(x>=0 && x<n && y>=0 && y<m && !pacific[x][y] && heights[x][y] >= heights[i][j])
                {
                    pacific[x][y] = true;
                    pq1.offer(new int[]{x, y});
                }
            }
        }

        while(!pq2.isEmpty())
        {
            int[] a = pq2.poll();

            int i = a[0];
            int j = a[1];

            for(int[] dir : dirs)
            {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x>=0 && x<n && y>=0 && y<m && !atlantic[x][y] && heights[x][y] >= heights[i][j])
                {
                    atlantic[x][y] = true;
                    pq2.offer(new int[]{x, y});
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}
