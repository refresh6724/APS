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
     * 계단은 한 번에 1,2,3 칸 올라갈 수 있을 때 
     * n 칸을 올라가는 방법 x가지를 10^10 + 7 로 나눈 나머지를 리턴 
     */

		
	static final long MOD = 10000000007L;
    public static int stepPerms(int n) {

    	if(n < 3) {
    		return n;
    	}
    	long[] arr = new long[n+1];
    	arr[0] = 1;
    	arr[1] = arr[0] * 1; // 1
    	arr[2] = arr[0] * 1 + arr[1] * 1; // 2
    	arr[3] = arr[0] * 1 + arr[1] * 1 + arr[2] * 1; // 4
    	for (int i = 4; i <= n; i++) {
			arr[i] = (arr[i-3] + arr[i-2]) % MOD; 
			arr[i] = (arr[i] + arr[i-1]) % MOD;
		}    	
    	return (int) arr[n];
    	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, s).forEach(sItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int res = Result.stepPerms(n);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
