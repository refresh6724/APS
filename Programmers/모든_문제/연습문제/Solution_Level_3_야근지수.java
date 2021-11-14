import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_Level_3_야근지수 { // 제출일 2021-11-14 23:26

	// test
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4,3,3})); // 12
		System.out.println(solution(1, new int[] {2,1,2})); // 6
		System.out.println(solution(3, new int[] {1,1})); // 0
	}

	/**
	 * 
	 * @param n 1백만 이하 자연수, 퇴근까지 남은 시간
	 * @param works 길이 2만 이하, 각 5만 이하, 각 일에 대한 작업량
	 * @return 야근피로도를 최소화한 값
	 */
	public static long solution(int n, int[] works) {
		
		// n 이상 값을 최소로 줄인다 = PQ
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int work : works) {
			pq.add(work);
		}
		int p = 0;
		while(n-->0) {
			p = pq.poll();
			pq.add(p-1);
		}
		long q = 0;
		while(!pq.isEmpty()) {
			p = pq.poll();
			if(p>0) {
				q += p*p;
			}
		}
		return q;
    }
} 