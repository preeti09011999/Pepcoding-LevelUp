import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    int res[] = new int[a.length+b.length];
    // pointer for array1 
    int d1 = 0;
    // pointer for array2
    int d2 = 0;
    
    int idx = 0;
    while(d1 < a.length && d2 < b.length){
        if(a[d1] < b[d2] ){
            // d1 pointer consumed
            res[idx++] = a[d1++];
        }else{
            res[idx++] = b[d2++];
        }
    }
    
    while(d1 < a.length){
        res[idx++] = a[d1++];
    }
    while(d2 < b.length){
        res[idx++] = b[d2++];
    }
    
    return res;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}
