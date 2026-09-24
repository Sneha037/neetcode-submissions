class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> res = new ArrayList<>();
        
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++)
        {
            Arrays.fill(board[i], '.');
        }

        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> ld = new HashSet<>();
        HashSet<Integer> rd = new HashSet<>();
        
        backtrack(res, 0, n, board, cols, ld, rd);

        return res;
    }

    public void backtrack(List<List<String>> res, int row, int n, char[][] board, HashSet<Integer> cols, HashSet<Integer> ld, HashSet<Integer> rd)
    {
        if(row == n)
        {
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int col = 0; col<n; col++)
        {
            if(cols.contains(col) || ld.contains(row-col) || rd.contains(row+col))
            {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            ld.add(row-col);
            rd.add(row+col);

            backtrack(res, row+1, n, board, cols, ld, rd);

            board[row][col] = '.';
            cols.remove(col);
            ld.remove(row-col);
            rd.remove(row+col);
        }
    }
}
