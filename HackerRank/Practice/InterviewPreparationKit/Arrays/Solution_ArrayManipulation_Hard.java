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
     * 숫자가 저장될 배열 길이 n 3 이상 10^7 이하
     * [시작idx, 종료idx, 더할 값 k] * m개 query 1 이상 2 * 10^5 이하
     * 각 k 값 0 이상 10^9 이하
     * 즉 최대값은 2 * 10^5 * 10^9
     * 범위가 아니라 값 1개만 구하면 되므로 queries를 정렬하여 최대값 찾기 => O(m^2) = 10^10
     * 값을 누적하여 최대값 찾기 => O(m) = 10^5
     */

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
	    
		long[] stack = new long[n+2];
		
		for(List<Integer> query : queries) {
			int start = query.get(0);
    		int end = query.get(1);
    		int k = query.get(2);
    		stack[start] += k;
    		stack[end+1] -= k;    		
		}
		
		long max = 0;
		for (int i = 1; i < stack.length; i++) {
			stack[i] += stack[i-1];
			max = Math.max(max, stack[i]);
		}
    	return max;
    }
	
	// 7~13 7개 시간 초과
    public static long arrayManipulation_FirstTry(int n, List<List<Integer>> queries) {
    
    	Collections.sort(queries, new Comparator<List<Integer>>() {
    		@Override
    		public int compare(List<Integer> o1, List<Integer> o2) {
    			if(o1.get(1) == o2.get(1)) {
    				return o2.get(0) - o2.get(0);
    			}
    			return o1.get(1) - o2.get(1);
    		}
    	});
    	
    	Queue<long[]> q = new LinkedList<>();
    	for(List<Integer> query : queries) {
    		int start = query.get(0);
    		int end = query.get(1);
    		int k = query.get(2);
    		int size = q.size();
    		boolean now = false;
    		for (int i = 0; i < size; i++) {
				long[] next = q.poll();
				if(start <= next[0] && next[0] < end) {
					next[1] += k;
				} else if(next[0] == end) {
					now = true;
					next[1] += k;
				}
				q.add(next);
			}
    		if(!now) {
    			q.add(new long[] {end, k});
    		}
    	}
    	
    	long max = 0;
    	while(!q.isEmpty()) {
    		max = Math.max(max, q.poll()[1]);
    	}
    	return max;
    }

}

public class Solution_ArrayManipulation_Hard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
