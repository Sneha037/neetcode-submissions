class Solution {
    public boolean isPalindrome(String s) {

        s = s.trim();
        s = s.toLowerCase();
        int n = s.length();

        int l = 0;
        int r = n-1;


        while(l<=r)
        {
            char c = s.charAt(l);
            char ch = s.charAt(r);
            if(!((c>='a' && c<='z') || (c>='0' && c<='9')))
            {
                l++;
                continue;
            }
            else if(!((ch>='a' && ch<='z') || (ch>='0' && ch<='9')))
            {
                r--;
                continue;
            }

            if(c != ch)
               return false;

            l++;
            r--;
        }

        return true;
    }
}
