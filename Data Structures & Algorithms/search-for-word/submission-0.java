class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(word.charAt(0) == board[i][j])
                    if(helper(board, word, i, j, 0))
                        return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int r, int c, int index)
    {
        if(index == word.length())
            return true;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(index) != board[r][c])
            return false;

        char originalWord = board[r][c];
        board[r][c] = '#';

        boolean found = helper(board, word, r+1, c, index+1) ||
                        helper(board, word, r-1, c, index+1) ||
                        helper(board, word, r, c+1, index+1) ||
                        helper(board, word, r, c-1, index+1);

        board[r][c] = originalWord;

        return found;
    }
}
