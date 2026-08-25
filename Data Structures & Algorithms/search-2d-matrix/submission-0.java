class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int j = m-1; int i =0;

        while(i>=0 && i<n && j>=0 && j<m)
        {
            int a = matrix[i][j];

            if(a == target)
              return true;
            else if(a > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }

        return false;
    }
}
