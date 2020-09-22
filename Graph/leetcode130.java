class Solution {
    public void solve(char[][] board) {
        
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(j==0||i==0||i==board.length-1||j==board[0].length-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,board,dir);
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
        
    }
    
    public void dfs(int i,int j,char[][] board,int[][] dir){
        board[i][j] = '#';
        for(int d=0;d<dir.length;d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c] == 'O'){
                dfs(r,c,board,dir);
            }
        }
    }
}
