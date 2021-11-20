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
     * s 길이는 1 이상 100 이하, n은 1 이상 10^12 이하
     * aba가 무한히 반복되는 string에서 n 길이 내부에 a가 몇 개 있는지 리턴
     */

    public static long repeatedString(String s, long n) {
    	
    	int cnt = 0;
    	for(char c : s.toCharArray()) {
    		if(c == 'a') {
    			cnt++;
    		}
    	}
    	long div = n / s.length();
    	long ret = div * cnt;
    	int nam = (int) (n % s.length());
    	for (int i = 0; i < nam; i++) {
			if(s.charAt(i) == 'a') {
				ret++;
			}
		}
    	return ret;

    }

}

public class Solution_RepeatedString { // 제출일 2021-11-20 23:12
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
