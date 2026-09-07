class Solution {
    public int reverse(int x) 
    {
       long a = Math.abs((long)x);

       int ans = 0;

       while(a != 0)
       {
          int d = (int)(a%10);
          
          if(ans > (Integer.MAX_VALUE - d)/10)
          {
              return 0;
          }

          ans = ans*10 + d;
          a/= 10;
       }  

       if(x < 0)
       {
           ans = -1 * ans;       
       }

       return ans; 
    }
}
