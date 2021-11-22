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
     * 1차원 배열 a에 대해 d만큼 회전한 뒤의 배열을 그대로 리턴
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    	if(d == a.size()) {
    		return a;
    	}
    	Iterator<Integer> it = a.iterator();
    	Queue<Integer> left = new LinkedList<>();
    	List<Integer> right = new ArrayList<>();
    	while(d-->0) {
    		left.add(it.next());
    	}
    	
    	while(it.hasNext()) {
    		right.add(it.next());
    	}
    	while(!left.isEmpty()) {
    		right.add(left.poll());
    	}
    	return right;
    }

}

public class Solution_ArraysLeftRotation_Easy {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
