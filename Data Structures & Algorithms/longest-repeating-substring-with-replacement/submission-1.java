class Solution {
    public int characterReplacement(String s, int k) 
    {
        int n = s.length(); 

        int left = 0;

        int right = 0;

        int[] freq = new int[26];

        int maxFreq = 0;

        int maxLen = 0;

        while(right < n)
        {
            char ch = s.charAt(right);

            freq[ch - 'A'] = freq[ch - 'A'] + 1;

            for(int i=0; i<26; i++)
            {
                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            }

            int len = right - left + 1;

            int replacements = len - maxFreq;

            while(replacements > k)
            {
                char ch2 = s.charAt(left);
                left++;
                freq[ch2 - 'A'] = freq[ch2 - 'A'] - 1;
                replacements = right - left + 1 - maxFreq;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
