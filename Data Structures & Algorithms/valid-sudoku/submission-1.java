class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        int n = board.length;

        for(int i=0; i<n; i++)
        {
            HashSet<Integer> row = new HashSet<Integer>();
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == '.')
                   continue;

                int a = board[i][j] - '0';

                if(row.contains(a))
                {
                    return false;
                }

                row.add(a);
            }
        }
        
        for(int j=0; j<n; j++)
        {
            HashSet<Integer> col = new HashSet<>();
            for(int i=0; i<n; i++)
            {
                if(board[i][j] == '.')
                    continue;
                
                int a = board[i][j] - '0';

                if(col.contains(a))
                   return false;
                
                col.add(a);
            }
        }

        int k = (int)Math.sqrt(n);

        for(int i=0; i<k; i++)
        {
            for(int j=0; j<k; j++)
            {
                HashSet<Integer> block = new HashSet<>();

                int x = i*k;
                int y = j*k;

                for(int p=x; p<x+k; p++)
                {
                    for(int q=y; q<y+k; q++)
                    {
                        if(board[p][q] == '.')
                            continue;

                        int a = board[p][q] - '0';

                        if(block.contains(a))
                            return false;

                        block.add(a);
                    }
                }
            }
        }

        return true;
    }
}
