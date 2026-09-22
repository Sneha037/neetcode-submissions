class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;

       /* int[] left = new int[n];
        int[] right = new int[n];

        left[0] = heights[0];
        */

        Stack<Integer> st = new Stack<>();

        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            int a = heights[i];

            while(!st.isEmpty() && a < heights[st.peek()])
            {
                int index = st.pop();

                int b = heights[index];

                int width = 0;

                if(st.isEmpty())
                {
                    width = i;
                }
                else
                {
                    width = i - st.peek()-1;
                }

                maxArea = Math.max(maxArea, b * width);
            }
            
            st.push(i);
        }

        while(!st.isEmpty())
        {
            int p = st.pop();

            int width = 0;

            if(st.isEmpty())
            {
                width = n;
            }
            else
            {
                width = n-st.peek()-1;
            }

            maxArea = Math.max(maxArea, heights[p] * width);
        }

        return maxArea;
    }
}
