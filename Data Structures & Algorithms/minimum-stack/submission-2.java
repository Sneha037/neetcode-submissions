class MinStack {
   /* ArrayList<Integer> ans;
    int min = Integer.MAX_VALUE;
    int top = -1;

    public MinStack() 
    {
        ans = new ArrayList<>();
    }
    
    public void push(int val) 
    {
        ans.add(val);
        min = Math.min(min, val);
        top++;
    }
    
    public void pop() 
    {
        if(top == -1)
           return;
        int a = ans.remove(top);
        if(a == min)
        {
            min = Integer.MAX_VALUE;
            for(int i=0; i<top; i++)
            {
                min = Math.min(min, ans.get(i));
            }
        }
        top--;   
    }
    
    public int top() 
    {  
       return ans.get(top); 
    }
    
    public int getMin() 
    {
        return min;
    }
    */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack()
    {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val)
    {
        stack.push(val);
        if(minStack.size() > 0 && minStack.peek() < val)
        {
            minStack.push(minStack.peek());
        }
        else
        {
            minStack.push(val);
        }
    }

    public void pop()
    {
        stack.remove(stack.size()-1);
        minStack.remove(minStack.size()-1);
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }
}
