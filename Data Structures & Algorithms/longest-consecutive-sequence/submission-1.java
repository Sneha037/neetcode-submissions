class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        Arrays.sort(nums);

        for(int i=0; i<n; i++)
        {
            int a = nums[i];

            if(hm.containsKey(a-1))
            {
                hm.put(a, hm.get(a-1)+1);
            }
            else
            {
                hm.put(a, 1);
            }
        }

        int res = 0;

        for(int i : hm.values())
        {
            res = Math.max(res, i);
        }

        return res;
    }
}
