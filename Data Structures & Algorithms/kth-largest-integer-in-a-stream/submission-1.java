class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            int a = nums[i];
            pq.offer(a);
        }   
    }
    
    public int add(int val) 
    {
        pq.offer(val);
        Stack<Integer> st = new Stack<>();

        int s = pq.size();

        while(s>k)
        {
            st.push(pq.poll());
            s--;
        }

        int ans = pq.peek();

        while(!st.isEmpty())
        {
            pq.offer(st.pop());
        }

        return ans;
    }
}
