class Solution {
    public int numEnclaves(int[][] A) {
        int countone=0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                countone += A[i][j];
                if((i==0 || j==0 || i==A.length-1 || j==A[0].length-1) && A[i][j] == 1){
                    que.addLast(i*A[0].length + j);
                    countone--;
                    A[i][j] = 0;
                }
            }
        }
        if(countone == 0) return 0;
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int idx = que.removeFirst();
                int x = idx / A[0].length;
                int y = idx % A[0].length;
                for(int d=0;d<dir.length;d++){
                    int r = x + dir[d][0];
                    int c = y + dir[d][1];
                    if(r>=0 && c>=0 && r<A.length && c<A[0].length && A[r][c] == 1){
                        A[r][c] = 0;
                        que.addLast(r*A[0].length + c);
                        countone--;
                    }
                }
            }
            if(countone == 0) return 0;
        }
        return countone;
    }
}
