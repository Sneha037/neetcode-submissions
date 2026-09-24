class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        int n = candidates.length;

        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, target, res, 0, new ArrayList<Integer>());

        return res;
    }

    public void backtrack(int[] candidates, int sum, List<List<Integer>> res, int index, List<Integer> a)
    {
        if(sum < 0 || index > candidates.length)
        {
            return;
        }

        if(sum == 0)
        {
            res.add(new ArrayList<>(a));
            return;
        }

        for(int i=index; i<candidates.length; i++)
        {
            if(i > index && candidates[i] == candidates[i-1])
            {
                continue;
            }
            
            a.add(candidates[i]);
            backtrack(candidates, sum-candidates[i], res, i+1, a);
            a.remove(a.size()-1);
        }
    }
}
