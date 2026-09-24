class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        int m = tasks.length;
        
        int[] freq = new int[26];

        for(int i=0; i<m; i++)
        {
            freq[tasks[i] - 'A']++;
        }

        int maxFreq = 0;

        for(int i=0; i<26; i++)
        {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        int countMax = 0;

        for(int i=0; i<26; i++)
        {
            if(freq[i] == maxFreq)
                countMax++;
        }

        int ans = Math.max(m, (maxFreq - 1) * (n + 1) + countMax);

        return ans;
    }
}
