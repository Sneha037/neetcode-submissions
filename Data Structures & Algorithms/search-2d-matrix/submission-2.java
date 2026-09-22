class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
       /* int i = 0;
        int j = m-1;

        while(i<n && j>=0)
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
        */

        int left = 0;
        int right = n*m - 1;

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            int row = mid/m;
            int col = mid%m;

            int a = matrix[row][col];

            if(a == target)
            {
                return true;
            }
            else if(a > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return false;
    }
}
