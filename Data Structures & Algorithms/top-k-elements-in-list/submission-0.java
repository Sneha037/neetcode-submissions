class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> hm = new HashMap<>();

        Comparator<Pair> comp = new Comparator<Pair>()
        {
            public int compare(Pair a, Pair b)
            {
                return b.freq - a.freq;
            }
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(comp);
        
        int n = nums.length;

        for(int i=0; i<n; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        for(int i : hm.keySet())
        {
            pq.offer(new Pair(i, hm.get(i)));
        }

        int c = k;

        int[] res = new int[k];

        while(c>0)
        {
            res[k-c] = pq.poll().num;
            c--;
        }

        return res;
    }
}

class Pair
{
    int num;
    int freq;

    public Pair(int num, int freq)
    {
        this.num = num;
        this.freq = freq;
    }
}
