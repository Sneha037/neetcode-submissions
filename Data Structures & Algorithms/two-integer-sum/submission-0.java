class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] ans = new int[2];

        for(int i=0; i<n; i++)
        {
            int a = nums[i];

            if(hm.containsKey(target - a))
            {
                ans[0] = hm.get(target-a);
                ans[1] = i;

                return ans; 
            }

            hm.put(a, i);
        }

        return ans;
    }
}
