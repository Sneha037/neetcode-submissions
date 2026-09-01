class MinStack {
    ArrayList<Integer> ans;
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
}
