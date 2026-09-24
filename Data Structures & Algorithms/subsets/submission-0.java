class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[n];

        backtrack(nums, res, 0, new ArrayList<Integer>(), used);

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int index, List<Integer> a, boolean[] used)
    {
        if(index == nums.length)
        {
            List<Integer> subset = new ArrayList<>(a);
            ans.add(subset);
            return;
        }

        a.add(nums[index]);
        used[index] = true;
        backtrack(nums, ans, index+1, a, used);
        used[a.size()-1] = false;
        a.remove(a.size()-1);
        backtrack(nums, ans, index+1, a, used);
    }
}
