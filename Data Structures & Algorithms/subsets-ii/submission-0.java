class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

       // boolean[] used = new boolean[n];

        HashSet<List<Integer>> hs = new HashSet<>();

        backtrack(nums, res, 0, new ArrayList<Integer>(), hs);

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int index, List<Integer> subset, HashSet<List<Integer>> hs)
    {
        if(index >= nums.length)
        {
            List<Integer> a = new ArrayList<Integer>(subset);
            if(!hs.contains(a))
            {
                res.add(a);
                hs.add(a);
            }
            return;
        }

        subset.add(nums[index]);
        backtrack(nums, res, index+1, subset, hs);
        subset.remove(subset.size()-1);
        backtrack(nums, res, index+1, subset, hs);
    }
}
