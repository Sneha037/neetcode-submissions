class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<n; i++)
        {
            pq.offer(intervals[i]);
        }

        pq.offer(newInterval);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(!pq.isEmpty())
        {
           int[] a = pq.poll();
           if(ans.size() == 0)
           {
              ArrayList<Integer> p = new ArrayList<>();
              p.add(a[0]);
              p.add(a[1]);

              ans.add(p);
           }
           else
           {
               ArrayList<Integer> p = ans.get(ans.size()-1);

               if(p.get(1) >= a[0])
               {
                   p.set(0, Math.min(p.get(0), a[0]));
                   p.set(1, Math.max(p.get(1), a[1]));
                   ans.remove(ans.size()-1);
                   ans.add(p);
               }
               else
               {   
                   p = new ArrayList<Integer>();
                   p.add(a[0]);
                   p.add(a[1]);
                   ans.add(p);
               }
           }
        }

        int[][] res = new int[ans.size()][2];

        for(int i=0; i<ans.size(); i++)
        {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }

        return res;
    }
}

