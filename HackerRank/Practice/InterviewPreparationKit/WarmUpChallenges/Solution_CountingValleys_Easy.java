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
     * 0에서 시작해 0으로 끝날 때 up down
     * 영어 어렵다...
     * -1에서 0으로 가면 시작 -1에서 0으로 가면 valley count +1 
     */

	public static int countingValleys(int steps, String path) {
		int depth = 0;
		int valleyCnt = 0;
		for(char ud : path.toCharArray()) {
			if(ud == 'U') {
				if(depth == -1) {
					valleyCnt++;
				}
				depth++;
			} else {
				depth--;
			}
		}
		return valleyCnt;
    }
}

public class Solution_CountingValleys_Easy { // 제출일 2021-11-18 23:32
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
