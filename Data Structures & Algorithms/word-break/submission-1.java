class Solution {
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n = wordDict.size();
        
        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<n; i++)
        {
            hs.add(wordDict.get(i));
        }

        ArrayList<Boolean> dp = new ArrayList<>(Collections.nCopies(s.length()+1, null));
        dp.set(0, true);

        return solve(s, dp, s.length(), hs);
    }

    public boolean solve(String s, ArrayList<Boolean> dp, int i, HashSet<String> hs)
    {
        if(dp.get(i) != null)
           return dp.get(i);

        boolean flag = false;

        for(int j=0; j<i; j++)
        {
            flag = solve(s, dp, j, hs) && hs.contains(s.substring(j, i));
            if(flag)
              break;
        }

        dp.set(i, flag);

        return dp.get(i);
    }
}
