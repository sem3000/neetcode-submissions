class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[][] blockSet = new HashSet[3][3];

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                Character n = board[i][j];

                if(n != '.')
                {
                    if(rowSet[i] == null)
                    {
                        rowSet[i] = new HashSet<>();
                        rowSet[i].add(n);
                    }
                    else if(!rowSet[i].contains(n))
                        rowSet[i].add(n);
                    else
                        return false;

                    if(colSet[j] == null)
                    {
                        colSet[j] = new HashSet<>();
                        colSet[j].add(n);
                    }
                    else if(!colSet[j].contains(n))
                        colSet[j].add(n);
                    else
                        return false;

                    if(blockSet[i/3][j/3] == null)
                    {
                        blockSet[i/3][j/3] = new HashSet<>();
                        blockSet[i/3][j/3].add(n);
                    }
                    else if(!blockSet[i/3][j/3].contains(n))
                        blockSet[i/3][j/3].add(n);
                    else
                        return false;
                }
            }
        }

        return true;
    }
}
