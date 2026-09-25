class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        int m = times.length;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            List<int[]> a = new ArrayList<>();
            graph.add(a);
        }

        for(int[] edge : times)
        {
            int u = edge[0]-1;
            int v = edge[1]-1;

            int d = edge[2];

            graph.get(u).add(new int[]{v, d});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        dist[k-1] = 0;
        pq.offer(new int[]{k-1, 0});

        while(!pq.isEmpty())
        {
            int[] a = pq.poll();

            int u = a[0];

            int dis = a[1];

            if(dis > dist[u])
               continue;

            for(int[] node : graph.get(u))
            {
                int v = node[0];
                int d = node[1];

                if((dis+d) < dist[v])
                {
                    dist[v] = dis+d;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++)
        {
            if(i == k-1)
              continue;

            if(dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
