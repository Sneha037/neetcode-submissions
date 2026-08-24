class Solution {
    public boolean isAnagram(String s, String t) 
    {
        int n = s.length(); int m = t.length();

        int[] schar = new int[26];
        int[] tchar = new int[26];

        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);

            schar[ch - 'a'] = schar[ch - 'a'] + 1;
        }

        for(int i=0; i<m; i++)
        {
            char ch = t.charAt(i);

            tchar[ch - 'a'] = tchar[ch - 'a'] + 1;
        }

        return (Arrays.equals(schar, tchar));
    }
}
