import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    boolean col[] = new boolean[board.length];
    boolean nd[] = new boolean[2*board.length-1];
    boolean rd[] = new boolean[2*board.length-1];
    nqueens(board,0,col,nd,rd,"");
  }
  
  public static void nqueens(boolean[][] board,int row,boolean[] col,boolean nd[],boolean rd[],String asf){
        if(row == board.length){
            System.out.println(asf+".");
            return;
        }
        for(int colm = 0;colm<board.length;colm++){
            if(col[colm]==false && nd[row + colm] == false && rd[row-colm+board.length-1]==false){
                col[colm] = true;
                nd[row+colm] = true;
                rd[row-colm+board.length-1] = true;
                nqueens(board,row+1,col,nd,rd,asf+row+"-"+colm+", ");
                col[colm] = false;
                nd[row+colm] = false;
                rd[row-colm+board.length-1] = false;
            }
        }    
      
  }

}
