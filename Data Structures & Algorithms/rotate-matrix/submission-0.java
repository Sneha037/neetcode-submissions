class Solution {
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++)
        {
            int p1 = 0; int p2 = n-1;

            while(p1<p2)
            {
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = temp;
                p1++;
                p2--;
            }
        }
    }
}
