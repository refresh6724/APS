import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * 예제 1
     * super_digit(9875)   	9+8+7+5 = 29 
	 * super_digit(29) 	2 + 9 = 11
	 * super_digit(11)		1 + 1 = 2
	 * super_digit(2)		= 2
	 * 
	 * 예제 2
	 * superDigit(p) = superDigit(9875987598759875)
     *               = 9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
     * superDigit(p) = superDigit(116)
     *               = 1+1+6 = 8
     * superDigit(p) = superDigit(8)
     */

	/**
	 * n이 k만큼 반복되는 수가 초기값으로 주어질 때 superDigit을 구하라
	 * @param n 1 이상 10^100000 이하
	 * @param k 1 이상 10^5 이하
	 * @return
	 */
    public static int superDigit(String n, int k) {
    	
    	if(n.length() == 1) {
    		return n.charAt(0) - '0';
    	}
    
    	long sum = 0;
    	for(char c : n.toCharArray()) {
    		sum += c - '0';
    	}
    	sum *= k;
    	
    	return intSuperDigit(Long.toString(sum));

    }

	private static int intSuperDigit(String n) {
		if(n.length() == 1) {
    		return n.charAt(0) - '0';
    	}
		
		int sum = 0;		
		for(char c : n.toCharArray()) {
    		sum += c - '0';
    	}
    	
    	return intSuperDigit(Long.toString(sum));
		
	}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
