class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        
        for(int i=1; i<mat.length; i++)
            mat[i][0] += mat[i-1][0];
        
        for(int j=1; j<mat[0].length; j++)
            mat[0][j] += mat[0][j-1];

        for(int i=1; i<mat.length; i++)
            for(int j=1; j<mat[0].length; j++)
                mat[i][j] = mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1] + mat[i][j];

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int upperPart = 0;
        int leftPart = 0;
        int commonPart = 0;
        
        if(row1 > 0)
            upperPart = mat[row1-1][col2];
        
        if(col1 > 0)
            leftPart = mat[row2][col1-1];
        
        if(row1 > 0 && col1 > 0)
            commonPart = mat[row1-1][col1-1];
        
        return mat[row2][col2] - upperPart - leftPart + commonPart;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */