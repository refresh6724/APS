public class Solution_Level_2_프린터 { // 제출일 2020-08-06 03:16
	public static int solution(int[] priorities, int location) {

		// brute-force
		// 모든 경우를 확인하는 경우
		// 한번 n 훑어서 중요도 저장
		// 다시 돌면서 최대 중요도를 찾아 인쇄
		// 최악의 케이스 1 2 3 4 // 1 2 3 // 1 2 // 1
		// 시간 복잡도 n^2

		// another
		// 리턴 대상의 중요도가 4라면 5까지 모두 처리된 다음
		// 그 다움 위치부터 순서 처리된다
		// 따라서 우선 가장 높은 우선순위의 마지막 오른쪽 끝을 찾고
		// 왼쪽으로 돌면서 그 다음 우선순위를 가장 처음 만나는 곳을 찾고
		// 같은 방법으로 반복해서
		// 우선순위가 리턴 대상과 같아지면 오른쪽으로 돈다
		// 최악의 경우 4 3 2 1 // 3 2 1 // 2 1 // 1

		// 1. 중요도의 누적 갯수를 저장
		int[] important = new int[10];
		int len = priorities.length;
		for (int i = 0; i < len; i++) {
			important[priorities[i]]++;
		}
		// 2. 중요도의 최댓값을 확인
		int max = 0;
		for (int i = 9; i >= 1; i--) {
			if (important[i] != 0) {
				max = i;
				break;
			}
		}
		
		int target = priorities[location];
		
		int idx = 0;
		int answer = 0;
		if (max != target) {
			// 3. 최댓값의 마지막 위치를 확인
			idx = len - 1;
			for (int i = idx; i >= 0; i--) {
				if (priorities[i] == max) {
					idx = i;
					max--;
					break;
				}
			}
			// 4. 타겟 이전에 처리되는 문서의 개수를 저장
			answer = 0;
			for (int i = 9; i >= 1; i--) {
				// 타겟이 5순위라면 9,8,7,6 을 미리 answer에 더해줄 것
				if (i == target) {
					break;
				}
				answer += important[i];
			}

			// 5. 타겟 바로 직전 우선순위의 마지막 출력 위치를 확인
			while (max != target) {
				if (important[max] == 0) { // 해당 우선순위 값이 없으면 바로 다음 우선순위로 이동
					max--;
					continue;
				}
				idx--;
				if (idx < 0) { // 왼쪽 끝을 넘어가면
					idx = len - 1; // 오른쪽 끝으로 이동
				}
				if (priorities[idx] == max) { // 가장 처음 만나는 위치를 체크
					max--;
				}
			}
		}

		// 6. idx 부터 오른쪽으로 몇 번 돌아야 location에 도착하는지 확인		
		int plus = 1;
		if(priorities[idx] != target) {
			plus--;
		}
		while (idx != location) {
			idx++;
			if (idx == len) {
				idx = 0;
			}
			if (priorities[idx] == target) {
				plus++;
			}
		}

		return answer + plus;
	}

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2)); // 1
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0)); // 5
		System.out.println(solution(new int[] { 1, 2, 1, 2, 1, 9, 1, 2, 1, 2, 1, 2, 1 }, 0)); // 12
		
		System.out.println(solution(new int[] { 1, 2, 3 }, 0)); // 3
		System.out.println(solution(new int[] { 9, 9, 9 }, 0)); // 1
		System.out.println(solution(new int[] { 9, 9, 9 }, 2)); // 3
		System.out.println(solution(new int[] { 1, 1, 1, 2 }, 1)); // 3
		System.out.println(solution(new int[] { 2, 1, 2, 1, 3, 2 }, 0)); // 3
	}
}