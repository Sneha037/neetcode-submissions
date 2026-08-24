class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++)
        {
            HashSet<Integer> row = new HashSet<>();
            for(int j=0; j<m; j++)
            {
                if(board[i][j] == '.')
                   continue;
                int a = board[i][j] - '0';

                if(row.contains(a)) 
                     return false;

                row.add(a);
            }
        }

        for(int j=0; j<m; j++)
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

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                int x = i*3;
                int y = j*3;

                HashSet<Integer> hs = new HashSet<>();

                for(int a=x; a<x+3; a++)
                {
                    for(int b=y; b<y+3; b++)
                    {
                        if(board[a][b] == '.')
                          continue;

                         int p = board[a][b] - '0';

                         if(hs.contains(p))
                            return false;

                        hs.add(p);
                    }
                }
            }
        }

        return true;
    }
}
