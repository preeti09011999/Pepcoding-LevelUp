class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return matrix;
        int vis[][] = new int[matrix.length][matrix[0].length];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int[] a:vis) Arrays.fill(a,-1);
        int countones = matrix.length * matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    countones--;
                    vis[i][j] = 0;
                    que.addLast(i*matrix[0].length + j);
                }
            }
        }
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        int level = 1;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int pb = que.removeFirst();
                int x = pb/matrix[0].length;
                int y = pb%matrix[0].length;
                for(int d=0;d<dir.length;d++){
                    int r = x + dir[d][0];
                    int c = y + dir[d][1];
                    if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length && vis[r][c] == -1){
                        vis[r][c] = level;
                        countones--;
                        que.addLast(r*matrix[0].length + c);
                    }
                }
            }
            level++;
            if(countones == 0) break;
        }
        return vis;
    }
}
