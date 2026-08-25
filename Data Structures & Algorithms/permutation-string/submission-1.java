class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        int n = s1.length();
        int m = s2.length();

        if(m<n)
          return false;
        
        HashMap<Character, Integer> hm1 = new HashMap<>();

        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            char ch = s1.charAt(i);

            hm1.put(ch, hm1.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<n; i++)
        {
            char ch = s2.charAt(i);

            hm2.put(ch, hm2.getOrDefault(ch, 0)+1);
        }


        if(hm1.equals(hm2))
           return true;

       /* for(Character ch : hm1.keySet())
        {
            if(hm2.containsKey(ch))
            {
                if(hm1.get(ch) != hm2.get(ch))
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return true;

        */
        
        for(int i=n; i<m; i++)
        {
            char ch1 = s2.charAt(i-n);
            char ch2 = s2.charAt(i);

            hm2.put(ch1, hm2.getOrDefault(ch1, 0)-1);

            if(hm2.get(ch1) == 0)
            {
                hm2.remove(ch1);
            }

            hm2.put(ch2, hm2.getOrDefault(ch2, 0)+1);

            if(hm1.equals(hm2))
               return true;
        }

        return false;
    }
}
