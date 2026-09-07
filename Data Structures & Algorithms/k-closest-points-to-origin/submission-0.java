class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> 
        Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));

        for(int i=0; i<n; i++)
        {
            pq.offer(points[i]);
        }
        
        int[][] ans = new int[k][2];
        int i=0;

        while(i<k)
        {
            int[] a = pq.poll();
            ans[i][0] = a[0];
            ans[i][1] = a[1];
            i++;
        }

        return ans;
    }
}
