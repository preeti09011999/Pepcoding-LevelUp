import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(lbs(arr));
    }
    
    public static int lbs(int[] arr){
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        lis[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i] >= arr[j]){
                    if(lis[i]<lis[j]){
                        lis[i] = lis[j];
                    }
                }
            }
            lis[i] += 1;
        }
        lds[arr.length-1] = 1;
        for(int i=arr.length-2;i>=0;i--){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] >= arr[j]){
                    if(lds[i] < lds[j]){
                        lds[i] = lds[j];
                    }
                }
            }
            lds[i] += 1;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(lis[i]+lds[i] > max){
                max = lis[i]+lds[i]-1;
            }
        }
        return max;
    }
    

}
