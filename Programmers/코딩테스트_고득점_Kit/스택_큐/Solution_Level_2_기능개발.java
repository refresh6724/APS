import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Level_2_기능개발 { // 제출일 2020-08-03 22:32
	public static int[] solution(int[] progresses, int[] speeds) {

		// 예제
		// progresses 	speeds 		return
		// [93,30,55] 	[1,30,5] 	[2,1]
		// 93 + n = 100 	-- 7 -- 7
		// 30 + 30 n >= 100 -- 3 -- 7보다 작으므로 넣는다
		// 55 + 5 n >= 100	-- 9 -- 7보다 크므로 넣지 못한다
		// 앞 기능이 완성되어야 같이 배포 가능하다

		// 1. 새로운 배열을 만들어 n을 구한다
		int[] time = new int[progresses.length];
		for (int i = 0; i < time.length; i++) {
			// (100-pro)/speed 올림
			int t = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				time[i] = t + 1;
			} else {
				time[i] = t;
			}
		}

		// 2. 최댓값을 갱신하면서 배포 개수를 센다
		ArrayList<Integer> li = new ArrayList<>();
		int max = time[0];
		int release = 1;
		for (int i = 1; i < time.length; i++) {
			if (max < time[i]) { // 기존 최댓값보다 크다면 li에 넣고 교체
				li.add(release);
				max = time[i];
				release = 1;
			} else {
				release++;
			}
		}
		if (release != 0) {
			li.add(release);
		}

		// 3. ArrayList to Array
		int n = li.size();
		int[] answer = new int[n];
		int j = 0;
		for (int i : li) {
			answer[j++] = i;
		}
		return answer;
	}

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
	}
}