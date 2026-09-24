class Solution {
    public boolean exist(char[][] board, String word) 
    {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                char ch = board[i][j];
                boolean[][] visited =  new boolean[n][m];

                if(ch == word.charAt(0))
                {
                    if(word.length() == 1)
                       return true;

                    if(dfs(board, word, i, j, visited, 1, dirs))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited, int index, int[][] dirs)
    {
        visited[row][col] = true;

        for(int[] dir : dirs)
        {
            int x = row + dir[0];
            int y = col + dir[1];

            if(x>=0 && x<board.length && y>=0 && y<board[0].length && !visited[x][y] && board[x][y] == word.charAt(index))
            {
                if(index == word.length()-1)
                {
                    return true;
                }

                if(dfs(board, word, x, y, visited, index+1, dirs))
                    return true;
            }
        }
        
        visited[row][col] = false;
        return false;
    }
}
