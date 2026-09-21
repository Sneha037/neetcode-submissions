class Solution {
    public int longestConsecutive(int[] nums) 
    {
        /*
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
        */

        int n = nums.length;

        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums)
        {
            hs.add(num);
        }

        int max = 0;

        for(int i=0; i<n; i++)
        {
            int a = nums[i];

            if(!hs.contains(a-1))
            {
                int len = 1;
                int num = a;

                while(hs.contains(num+1))
                {
                    len++;
                    num++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
