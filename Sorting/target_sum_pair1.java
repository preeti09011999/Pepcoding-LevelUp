import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
      int i = 0;
      int j = arr.length-1;
      // step 1. -> to sort the array
      Arrays.sort(arr);
      // sptep 2 -> apply two pointer approach
    while(i<j){
        if(arr[i]+arr[j]<target){
            i++;
        }else if(arr[i]+arr[j]>target){
            j--;
        }else if(arr[i]+arr[j] == target){
            System.out.println(arr[i]+", "+arr[j]);
            i++;
            j--;
        }
    }

  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}
