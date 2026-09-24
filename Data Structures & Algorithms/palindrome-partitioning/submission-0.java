class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> res = new ArrayList<>();

        backtrack(s, res, new ArrayList<>(), 0);

        return res;   
    }

    public void backtrack(String s, List<List<String>> res, List<String> current, int start)
    {
        if(start == s.length())
        {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int end = start; end < s.length(); end++)
        {
            if(isPalindrome(s, start, end))
            {
                current.add(s.substring(start, end+1));

                backtrack(s, res, current, end + 1);

                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
               return false;

            left++;
            right--;
        }

        return true;
    }
}
