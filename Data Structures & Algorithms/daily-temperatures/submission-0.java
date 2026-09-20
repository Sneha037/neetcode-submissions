class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n = temperatures.length;
        
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        for(int i=0; i<n; i++)
        {
            int a = temperatures[i];

            while(!st.isEmpty() && (temperatures[st.peek()] < a))
            {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);
        }

        while(!st.isEmpty())
        {
            ans[st.peek()] = 0;
            st.pop();
        }

        return ans;
    }
}
