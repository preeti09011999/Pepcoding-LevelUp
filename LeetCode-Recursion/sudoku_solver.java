class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> locOfZeroes = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    int idx = (i*9)+j;
                    locOfZeroes.add(idx);
                }
            }
        }
        sudoku_solver(board,0,locOfZeroes);
    }
    
       
    public boolean sudoku_solver(char[][] board,int idx,ArrayList<Integer> locOfZeroes){
        if(idx == locOfZeroes.size()){
            return true;
        }
        
        int count = 0;
        int vidx = locOfZeroes.get(idx);
        int r = vidx/9;
        int c = vidx%9;
        for(int num =1;num<=9;num++){
            if(isValidToPlace(board,r,c,num)){
                board[r][c] = (char)(num+'0');
                if(sudoku_solver(board,idx+1,locOfZeroes)) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }
    
    public boolean isValidToPlace(char[][] board,int r,int c,int num){
        
        // check in row
        for(int i=0;i<9;i++) if(board[r][i]==num+'0') return false;
        // check in col
        for(int j=0;j<9;j++) if(board[j][c] == num+'0') return false;
        // check in 3*3 matrix
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]==num+'0') return false;
            }
        }
        return true;
    }
}
