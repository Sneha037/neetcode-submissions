class Solution {
    public String longestPalindrome(String s) 
    {
        int n = s.length();

        int max = 0;

        int x = 0;
        int y = 0;

        for(int i=0; i<n; i++)
        {
            int odd = count(s, i, i);
            int even = count(s, i, i+1);
            System.out.println(odd + " " + even);

            max = Math.max(odd, even);

            if(max > (y-x+1))
            {
                x = i - (max - 1)/2;
                y = i + max/2;
            }
        }

        return s.substring(x, y+1);
    }

    public int count(String s, int i, int j)
    {
        while(i>=0 && j<s.length() && (s.charAt(i) == s.charAt(j)))
        {
            i--;
            j++;
        }

        return (j-i-1);
    }
}
