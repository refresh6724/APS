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
     * s1과 s2가 같은 알파벳을 가지고 있으면 YES 아니면 NO 반환
     */

    public static String twoStrings(String s1, String s2) {
    
    	Set<Character> alphabet = new HashSet<>();
    	for(char c : s1.toCharArray()) {
    		alphabet.add(c);
    	}
    	for(char c : s2.toCharArray()) {
    		if(alphabet.contains(c)) {
    			return "YES";
    		}
    	}
    	return "NO";

    }

}

public class Solution_TwoStrings_Easy {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
