public class Solution_Level_2_소수만들기 { // 제출일 2020-09-28 23:18

	// test
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4})); // 1
		System.out.println(solution(new int[] {1,2,7,6,4})); // 4
	}
	
	static boolean[] isPrime;
	
	static void prime() {
		isPrime = new boolean[3000];
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}		
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				for (int j = i+i; j < isPrime.length; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}

	static int ans;
	
	public static int solution(int[] nums) {
		
		// 주어진 수 중 3개를 더했을때 소수가 되는 경우
		// nums 길이는 50 이하
		// 각 원소는 최대 1000, 중복 없음
		// 즉 최대 3000 미만의 소수
		prime();
		ans = 0;
		for (int start = 0; start < nums.length; start++) {
			dfs(start, 1, nums[start], nums);
		}
		return ans;
	}

	private static void dfs(int start, int step, int sum, int[] nums) {
		if(step == 3) {
			if(isPrime[sum]) {
				ans++;
			}
			return;
		}
		
		for (int next = start+1; next < nums.length; next++) {
			dfs(next, step+1, sum+nums[next], nums);
		}
		
		return;
	}

}