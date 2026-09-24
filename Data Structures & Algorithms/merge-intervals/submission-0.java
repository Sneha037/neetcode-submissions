class Solution {
    public int[][] merge(int[][] intervals) 
    {
         int n = intervals.length;

         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  

         List<int[]> res = new ArrayList<>();

          res.add(intervals[0]);

          for(int i=1; i<n; i++)
          {
              int a[] = intervals[i];

              int b[] = res.get(res.size()-1);

              if(a[0] <= b[1])
              {
                  b[0] = Math.min(a[0], b[0]);
                  b[1] = Math.max(a[1], b[1]);
              }
              else
              {
                   int[] p = new int[2];
                   p[0] = a[0];
                   p[1] = a[1];
                   res.add(p);
              }
          }
        
        int[][] ans = new int[res.size()][2];

        for(int i=0; i<res.size(); i++)
        {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}
