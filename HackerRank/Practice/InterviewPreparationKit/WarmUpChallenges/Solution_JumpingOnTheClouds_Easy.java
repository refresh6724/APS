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
     * 0 이면 ok 1 이면 넘어야 한다
     * 1칸 또는 2칸씩 이동 가능 
     * = 즉 2개 이상 연속된 번개구름은 없다
     * = 즉 번개구름 좌우는 무조건 밟아야 한다   
     * 
     */

    public static int jumpingOnClouds(List<Integer> c) {
    	int prev = -1;
    	int now = 0;
    	for(int next : c) {
    		switch(next) {
    		case 0:
    			int tmp = Math.min(prev, now) + 1;
    			prev = now;
    			now = tmp;
    			break;
    		case 1:
    			prev = now;
    			now = 99;
    			break;
    		}
    	}
    	return now;
    }

}

public class Solution_JumpingOnTheClouds_Easy { // 제출일 2021-11-19 23:40
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
