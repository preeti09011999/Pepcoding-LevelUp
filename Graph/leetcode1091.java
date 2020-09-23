class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length-1]==1) return -1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.addLast(0);
        int level = 0;
        grid[0][0] = 1; 
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int idx = que.removeFirst();
                int r = (idx / grid[0].length);
                int c = (idx % grid[0].length);
                if(r==grid.length-1 && c==grid[0].length-1) return level+1;
                for(int d=0;d<8;d++){
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == 0){
                        grid[x][y] = 1;
                        que.addLast(x*grid[0].length + y);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
