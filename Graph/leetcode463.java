class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int nbrs = 0;
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count++;
                    for(int d=0;d<dir.length;d++){
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if(r>=0 && c>=0 && r<grid.length && c < grid[0].length && grid[r][c] == 1){
                            nbrs++;
                        }
                    }
                }
            }
        }
        return 4*count - nbrs;
    }
}
