class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int n = nums.length;

        Arrays.sort(nums);
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            int a = nums[i];

            if(hm.containsKey(a-1))
            {
                hm.put(a, hm.get(a-1)+1);
            }
            else if(!hm.containsKey(a))
            {
                hm.put(a, 1);
            }
        }

        int max = 0;

        for(int i : hm.values())
        {
            max = Math.max(max, i);
        }

        return max;
    }
}
