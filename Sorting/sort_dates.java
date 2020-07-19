import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(int[] arr) {
    for(int itr = 1;itr<=3;itr++){
        countSort(arr,itr);
    }

  }

  public static void countSort(int[] arr,int itr) {
      // frequency array declaration
    int farr[];
    if(itr == 1){
        // maximum days : 31
        farr = new int[32];
    }
    else if(itr == 2){
        // maximum months : 12
        farr = new int[13];
    }else{
        farr = new int[10000];
    }
    // frequency array
    for(int date : arr){
        if(itr == 1){
            farr[date/1000000]++;
        }else if(itr == 2){
            farr[(date/10000)%100]++;
        }else{
            farr[(date%10000)]++;
        }
    }
    
    // prefix sum array
    for(int i=1;i<farr.length;i++){
        farr[i] += farr[i-1];
    }
    // ans array
    int ans[] = new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        int date = arr[i];
        int pos = 0;
        if(itr == 1){
            pos = farr[(date/1000000)]--;
        }else if(itr == 2){
            pos = farr[(date/10000)%100]--;
        }else if(itr == 3){
            pos = farr[(date%10000)]--;
        }
        ans[pos-1] = date;
    }
    
    for(int i=0;i<arr.length;i++){
        arr[i] = ans[i];
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = Integer.parseInt(str, 10);
    }
    sortDates(arr);
    print(arr);
  }

}
