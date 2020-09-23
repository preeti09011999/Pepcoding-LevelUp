class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int onecount = 0;
        ArrayDeque<Pair> que = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) onecount++;
                else if(grid[i][j] == 2) que.addLast(new Pair(i,j));
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int time = 0;
        if(onecount == 0) return 0;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Pair pb = que.removeFirst();
                for(int d=0;d<4;d++){
                    int x = pb.i + dir[d][0];
                    int y = pb.j + dir[d][1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length&&grid[x][y] == 1){
                        grid[x][y] = 2;
                        onecount--;
                        que.addLast(new Pair(x,y));
                        if(onecount == 0) return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
