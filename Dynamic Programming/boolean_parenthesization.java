import java.io.*;
import java.util.*;

public class Main {
    
    // public static class Pair{
    //     int tc;
    //     int fc;
    //     Pair(){
    //         this.tc = tc;
    //         this.fc = fc;
    //     }
    //     Pair(int tc, int fc){
    //         this.tc = tc;
    //         this.fc = fc;
    //     }
    // }
    
    // ----------------------recursion ---------------------------------------
    
// 	public static Pair solution_rec(String str1, String str2, int si, int ei) {
// 		if(si == ei){
// 		    if(str1.charAt(si) == 'T'){
// 		        return new Pair(1,0);
// 		    }else{
// 		        return new Pair(0,1);
// 		    }
// 		}
// 		Pair res = new Pair();
// 		for(int cp=si;cp<ei;cp++){
// 		    Pair left = solution(str1, str2, si, cp);
// 		    Pair right = solution(str1, str2, cp+1,ei);
// 		    char op = str2.charAt(cp);
// 		    Pair myPair = operate(left,right,op);
// 		    res.tc += myPair.tc;
// 		    res.fc += myPair.fc;
// 		}
// 		return res;
// 	}
	
	//------------------------tabulation----------------------------------------
	public static int solution_tab(String str1, String str2){
	    int n = str1.length();
	    int dpT[][] = new int[n][n];
	    int dpF[][] = new int[n][n];
	    for(int gap=0;gap<n;gap++){
	        for(int sp=0,ep=gap;ep<n;ep++,sp++){
	            if(gap == 0){
	                dpT[sp][ep] = str1.charAt(sp) == 'T' ? 1 : 0;
	                dpF[sp][ep] = str1.charAt(sp) == 'F' ? 1 : 0;
	            }
	           // else if(gap == 1){
	           //     if(str2.charAt(sp) == '^'){
	           //         dpT[sp][ep] = (dpT[sp][sp]*dpF[ep][ep]) + (dpT[ep][ep] * dpF[sp][sp]);
	           //         dpF[sp][ep] = (dpT[sp][sp]*dpT[ep][ep]) + (dpF[sp][sp]*dpF[ep][ep]);
	           //     }else if(str2.charAt(sp) == '&'){
	           //         dpT[sp][ep] = (dpT[sp][sp] * dpT[ep][ep]);
	           //         dpF[sp][ep] = (dpF[sp][sp] * dpT[ep][ep]) + (dpT[sp][sp] * dpF[ep][ep]) + (dpF[sp][sp] * dpF[ep][ep]);
	           //     }
	           //     else{
	           //         dpT[sp][ep] = (dpT[sp][sp] * dpF[ep][ep]) + (dpF[sp][sp] * dpT[ep][ep]) + (dpT[sp][sp] * dpT[ep][ep]);
	           //         dpF[sp][ep] = dpF[sp][sp] * dpT[ep][ep];
	           //     }
	           // }
	           else{
	                for(int cp=sp;cp<ep;cp++){
	                    int left_t = dpT[sp][cp], left_f = dpF[sp][cp];
	                    int right_t = dpT[cp+1][ep], right_f = dpF[cp+1][ep]; 
	                    if(str2.charAt(cp)== '^'){
	                        dpT[sp][ep] += (left_t*right_f) + (left_f * right_t);
	                        dpF[sp][ep] += (left_f * right_f) + (left_t * right_t); 
	                    } 
	                    else if(str2.charAt(cp) == '|'){
	                        dpT[sp][ep] += (left_t * right_f) + (left_f * right_t) + (left_t * right_t);
	                        dpF[sp][ep] += (left_f * right_f);
	                    }
	                    else{
	                        dpT[sp][ep] += (left_t * right_t);
	                        dpF[sp][ep] += (left_f * right_t) + (left_t * right_f) + (left_f * right_f);
	                    }
	                    
	                }
	            }
	        }
	    }
	    return dpT[0][n-1];
	}
	
// 	public static Pair operate(Pair left, Pair right, char op){
// 	    Pair res = new Pair();
// 	    if(op == '&'){
// 	        res.tc = left.tc * right.tc;
// 	        res.fc = (left.fc * right.tc) + (left.tc * right.fc) + (left.fc * right.fc);
// 	    }
// 	    if(op == '^'){
// 	        res.tc = (left.tc * right.fc) + (left.fc * right.tc);
// 	        res.fc = (left.tc * right.tc) + (left.fc * right.fc);
// 	    }
// 	    if(op == '/'){
// 	        res.tc = (left.tc * right.fc) + (left.fc * right.tc) + (left.tc * right.tc);
// 	        res.fc = (left.fc * right.fc);
// 	    }
// 	    return res;
// 	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution_tab(s1,s2));
// 		System.out.println(solution_rec(s1, s2, 0, s1.length()-1).tc);
	}

}
