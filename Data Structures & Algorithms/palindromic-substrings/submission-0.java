class Solution {
    public int countSubstrings(String s) 
    {
        int n = s.length();

        if(n<=1)
          return n;

        int count = 0;

        for(int i=0; i<n; i++)
        {
            int j = i; int k = i;

            while(j>=0 && k<n)
            {
                char a = s.charAt(j);
                char b = s.charAt(k);

                if(a==b)
                {
                    count++;
                }
                else
                {
                    break;
                } 
                
                j--; k++;
            }
        }
        
        for(int i=0; i<n; i++)
        {
            int j = i; int k = i+1;

            while(j>=0 && k<n)
            {
                char a = s.charAt(j);
                char b = s.charAt(k);

                if(a==b)
                {
                    count+=1;
                }
                else
                {
                    break;
                }

                j--; k++;
            }
        }
        
        return count;
    }
}
