import java.util.*;

public class Solution {
	public static void main(String[] args) { // 제출일 2020-03-28 23:11
    	Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int tc=1; tc<=TC; tc++) {
        	double p = sc.nextDouble();
            double q = sc.nextDouble();
            double s1 = q-p*q;
            double s2 = p*(q-q*q);
            if(s1<s2) {
            	System.out.println(String.format("#%d YES",tc));
            } else {
            	System.out.println(String.format("#%d NO",tc));
            }           
            
        }
    
    }
    
}
