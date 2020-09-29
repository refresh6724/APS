import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_Level_2_영어끝말잇기 { // 제출일 2020-09-29 21:21

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" }))); // 3,3
		System.out.println(Arrays.toString(solution(5,
				new String[] { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" }))); // 0,0
		System.out.println(Arrays.toString(solution(2, 
				new String[] { "hello", "one", "even", "never", "now", "world", "draw" }))); // 1,3
	}

	public static int[] solution(int n, String[] words) {
		// 사람수, 번갈아 나오는 단어
		// 몇번째 사람이 몇번째 단어에서 탈락하는가를 리턴, 탈락자가 없다면 0,0 리턴

		int[] ret = new int[2];
		Set<String> set = new HashSet<>();
		set.add(words[0]);		
		for (int i = 1; i < words.length; i++) {
			if (set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
				ret[0] = (i % n) + 1;
				ret[1] = (i / n) + 1;
				break;
			}
			set.add(words[i]);
		}
		return ret;

	}
}