import java.io.*;
import java.util.*;

public class Main {

	public static int[] solution(String str1, String str2) {
		int n = str1.length();
		int minDp[][] = new int[n][n];
		int maxDp[][] = new int[n][n];
		for(int gap = 0;gap<n;gap++){
		    for(int sp=0,ep=gap;ep<n;ep++,sp++){
		        if(gap==0){
		            char ch = str1.charAt(sp);
		            minDp[sp][ep] = ch-'0';
		            maxDp[sp][ep] = ch-'0';
		        }else{
		            maxDp[sp][ep] = Integer.MIN_VALUE;
		            minDp[sp][ep] = Integer.MAX_VALUE;
		            for(int cp=sp;cp<ep;cp++){
		                int leftMax = maxDp[sp][cp], leftMin = minDp[sp][cp];
		                int rightMax = maxDp[cp+1][ep], rightMin = minDp[cp+1][ep];
		                char op = str2.charAt(cp);
		                if(op == '+'){
		                    maxDp[sp][ep] = Math.max(maxDp[sp][ep], leftMax+rightMax);
		                    minDp[sp][ep] = Math.min(minDp[sp][ep], leftMin + rightMin);
		                }
		                else if(op == '*'){
		                    maxDp[sp][ep] = Math.max(maxDp[sp][ep], leftMax*rightMax);
		                    minDp[sp][ep] = Math.min(minDp[sp][ep], leftMin*rightMin);
		                }
		            }
		        }
		    }
		}

		int res[] = new int[2];
		res[0] = minDp[0][n-1];
		res[1] = maxDp[0][n-1];
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '*') {
				str2 += ch;
			} else {
				str1 += ch;
			}
		}
		int[] arr = solution(str1, str2);
		System.out.println("Minimum Value -> " + arr[0]);
		System.out.println("Maximum Value -> " + arr[1]);
	}

}
