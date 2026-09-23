class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int n = s.length();

        HashSet<Character> hs = new HashSet<>();

        int p1 = 0;
        int p2 = 0;

        int res = 0;

        while(p2<n)
        {
            char ch = s.charAt(p2);

            if(!hs.contains(ch))
            {
                hs.add(ch);
                p2++;
            }
            else
            {
                while(p1<p2 && hs.contains(ch))
                {
                    char ch2 = s.charAt(p1);
                    hs.remove(ch2);

                    p1++;
                }
                hs.add(ch);
                p2++;
                //p1--;
            }

            res = Math.max(res, (p2-p1));
        }

        //res = Math.max(res, (p2-p1));

        return res;
    }
}
