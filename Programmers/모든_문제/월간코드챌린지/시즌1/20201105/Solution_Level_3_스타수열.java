import java.util.PriorityQueue;

// 문제 주소 https://programmers.co.kr/learn/courses/30/lessons/70130
// 풀고난 뒤 해설 https://prgms.tistory.com/33?category=882795
public class Solution_Level_3_스타수열 {

	// test
	public static void main(String[] args) {

	}
	
	public static int solution(int[] a) {
		// 길이가 1이면 수와 관계없이 0
		// 길이가 2 이상이지만 모든 수가 같은 수라면 0, 다른 수가 1쌍이라도 있다면 최소 2
		// 숫자가 abbaabba 순으로 반복되는 경우 스타 수열
		// 숫자가 abacadae 라면 스타 수열
		// a를 키라고 했을 때 b c d e 
		// dfs로 최대 25만번 ... 스택오버플로우
		
		int len = a.length;
		int[] cnt = new int[len+1];
		for(int aa : a) {
			cnt[aa]++;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(x,y)->((x[0]-y[0])==0)?(y[1]-x[1]):(y[0]-x[0])
		);
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0) {
				pq.add(new int[] {i, cnt[i]});
			}
		}
		int answer = 0;
		
		while(!pq.isEmpty()) {
			
			int[] b = pq.poll();
			if(b[1] <= answer) {
				continue; // 키의 개수와 상관없이 모두 다 돌거라면 pq 없이 앞에서부터 set만으로 이미 처리된 것을 넘어가는게 나은게 아닌가 싶기도 하고
			}
			int common = 0;
			int idx = 0;
			while(idx < len-1) {
				if ( (a[idx] != b[0] && a[idx+1] != b[0]) || (a[idx] == a[idx+1]) ) {
					idx++;
					continue;
				}
				common++;
				idx += 2;
			}
			answer = Math.max(answer, common);		
		}		
        return answer * 2;
    }
}