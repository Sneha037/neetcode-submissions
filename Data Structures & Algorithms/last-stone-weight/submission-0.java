class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        int n = stones.length;

        if(n==0)
          return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<n; i++)
        {
            pq.offer(stones[i]);
        }

        while(pq.size() > 1)
        {
            int x = pq.poll();
            int y = pq.poll();

            if(x == y)
            continue;

            pq.offer(Math.abs(x-y));
        }
        
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}
