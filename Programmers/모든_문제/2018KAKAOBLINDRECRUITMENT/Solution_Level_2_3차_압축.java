import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_Level_2_3차_압축 {

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
		// [11, 1, 27, 15]

		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
		// [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]

		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
		// [1, 2, 27, 29, 28, 31, 30]

	}

	public static int[] solution(String msg) {
		
		int max = 1;
		Map<String, Integer> dict = new HashMap<>();
		int idx = 1;
		for (int i = 0; i < 26; i++) {
			dict.put(String.valueOf((char)('A' + i)), idx++);
		}
        ArrayList<Integer> answer = new ArrayList<>();
		int left = 0;
		int right = Math.min(left + max, msg.length());
		while(left < right) {			
			while(!dict.containsKey(msg.substring(left, right))) {
				right--;
			}
			answer.add(dict.get(msg.substring(left, right)));
			if(right == msg.length()) {
				break;
			}			
			String next = msg.substring(left, right + 1);
			left = right;
			max = Math.max(max, next.length());
			dict.put(next, idx++);
			right = Math.min(left + max, msg.length());
		}
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}