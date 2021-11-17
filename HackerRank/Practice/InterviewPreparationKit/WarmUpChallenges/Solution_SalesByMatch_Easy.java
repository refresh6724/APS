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
     * 영어 해석이 더 어렵다...
     * 정수 n과 양말의 색깔(정수)를 담은 배열 ar이 주어진다.
     * 배열 ar에서 양말짝의 개수를 리턴하라
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    	Set<Integer> set = new HashSet<>();
    	int ans = 0;
    	for(int a : ar) {
    		if(set.contains(a)) {
    			set.remove(a);
    			ans++;
    		} else {
    			set.add(a);
    		}
    	}
    	return ans;
    }

}

public class Solution_SalesByMatch_Easy { // 제출일 2021-11-17 23:43
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
