import java.util.Arrays;

public class Solution_Level_2_소수찾기 { // 제출일 2020-08-18 17:43

	// test
	public static void main(String[] args) {
		System.out.println(solution("17")); // 3
		System.out.println(solution("011")); // 2
	}

	static boolean[] isPrime = new boolean[10000000];
	
	static void findPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				for (int j = i+i; j < isPrime.length; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
	static int prime;
	
	public static int solution(String numbers) {

		// numbers 는 길이 1 이상 7 이하
		// 1 에서 9,999,999 사이의 소수가 나오게 할 수 있다
		// numbers 조합의 경우의 수는
		// 7C7*7! + 7C6*6! + 7C5*5! + ... + 7C1*1!
		//  = 7 + 42 + 210 + 840 + 2520 + 5040 + 5040
		//  = 7 ( 1 + 6 + 30 + 120 + 360 + 720 + 720 ) 
		//  = 7 * 1957
		// 	= 13,699
		
		// 깊이가 7밖에 되지 않기 때문에 dfs로 처리
		findPrime();
		prime = 0;
		int visited=0;
		int sum = 0;
		for (int startIdx = 0; startIdx < numbers.length(); startIdx++) {
			dfs(numbers, visited, startIdx, sum);
		}	
		
		return prime;
	}

	private static void dfs(String numbers, int visited, int idx, int sum) {
		
		if(idx == numbers.length()) {
			if(isPrime[sum]) {
				isPrime[sum] = false; // 중복 방문 제거
				prime++;
				return;
			}
		}
		
		// unvisited idx를 방문
		for (int i = 0; i < numbers.length(); i++) {
			if((visited&(1<<i)) == 0) {
				dfs(numbers, (visited | (1<<i)), idx+1, (sum*10)+(numbers.charAt(i)-'0'));
			}
		}
		
	}
}