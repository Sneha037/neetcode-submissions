class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int n = s.length();
        
        int p1 = 0; int p2 = 0;

        HashSet<Character> hs = new HashSet<>();

        int ans = 0;

        while(p2<n)
        {
            char ch = s.charAt(p2);

            if(!hs.contains(ch))
            {
                ans = Math.max(ans, (p2-p1+1));
                hs.add(ch);
                p2++;
            }
            else
            {
                while(p1<p2)
                {
                    char c = s.charAt(p1);
                    p1++;
                    hs.remove(c);

                    if(!hs.contains(ch))
                    {
                        break;
                    }
                }

                ans = Math.max(ans, (p2-p1+1));
                hs.add(ch);
                p2++;
            }
        }

        return ans;
    }
}
