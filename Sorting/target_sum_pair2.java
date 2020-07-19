import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target) {
      // step 1 -> find pivot
      int i = pivotIdx(arr);
      int j = pivotIdx(arr)-1;
      // to limit while loop we can use count variable
      int count  = 0;
    while(arr.length - count > 1){
        if(arr[i] + arr[j] < target){
            i = (i+1)%arr.length;
            count++;
        }
        else if(arr[i] + arr[j] > target){
            j = (j-1+arr.length)%arr.length;
            count++;
        }
        else{
            System.out.println(arr[i]+", "+arr[j]);
            i = (i+1)%arr.length;
            j = (j-1+arr.length)%arr.length;
            count += 2;
        }
    }    

  }

    public static int pivotIdx(int arr[]){
        int pivot = 0;
      for(int i=0;i<arr.length;i++){
          if(arr[i] < arr[pivot]){
              pivot = i;
              break;
          }
      }
      return pivot;
    } 

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}
