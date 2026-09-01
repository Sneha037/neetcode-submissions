class Solution {
    public int evalRPN(String[] tokens) 
    {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        if(n == 1)
        {
            return Integer.parseInt(tokens[0]);
        }

        for(int i=0; i<n; i++)
        {
            String a = tokens[i];

            if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/"))
            {
                int x = st.pop();
                int y = st.pop();

                int ans = 0;

                if(a.equals("+"))
                {
                    ans = x+y;
                }
                else if(a.equals("-"))
                {
                    ans = y-x;
                }
                else if(a.equals("*"))
                {
                    ans = x*y;
                }
                else
                {
                    if(x != 0)
                    {
                        ans = y/x;
                    }
                }

                st.push(ans);
            }
            else
            {
                st.push(Integer.parseInt(a));
            }
        }

        return st.pop();
    }
}
