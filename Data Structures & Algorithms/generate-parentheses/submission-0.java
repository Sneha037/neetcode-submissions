class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> res = new ArrayList<>();
        
        backtrack(n, res, new StringBuilder(), 0, 0);

        return res;
    }

    public void backtrack(int n, List<String> res, StringBuilder sb, int open, int close)
    {
        if(sb.length() == 2*n)
        {
            res.add(sb.toString());
            return;
        }
       
        if(open < n)
        {
            sb.append('(');
            backtrack(n, res, sb, open + 1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
            sb.append(')');
            backtrack(n, res, sb, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
