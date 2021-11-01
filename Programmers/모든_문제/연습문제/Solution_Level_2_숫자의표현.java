public class Solution_Level_2_숫자의표현 {

	// test
	public static void main(String[] args) {
		System.out.println(solution(15)); // 4
	}

	// 첫번째 방법
	// 한번에 10개, 100개씩 찍는 경우 미리 계산하기
	// 다만 이 경우 2^9999 가지 경우의 수가 되어 시간초과가 된다
	static int[] num;

	static void cnt() {
		num = new int[10001];
		dfs(0, 0);
	}

	private static void dfs(int now, int sum) {
		if (now > 10000 || sum > 10000) {
			return;
		}
		num[now] += 1;
		// 연속적으로 이어나가는 수
		dfs(now + 1, sum + now);
		// 다음 수부터 새로 시작하는 수
		dfs(now + 1, now + 1);
	}

	// 두번째 방법
	// 1부터 시작하여 문제처럼 브루트포스로 풀기
	static int startHalf(int n) {
		int cnt = 0;
		for (int i = 1; i <= n / 2; i++) {
			int j = i;
			int sum = 0;
			while (sum < n) {
				sum += j;
				j++;
			}
			if (sum == n) {
				cnt++;
			}
		}
		return cnt + 1;
	}

	// 세번째 방법
	// 수학적 원리를 사용
	// 1에서 n까지의 합은 n(n+1)/2 가 되므로
	// a 부터 b 까지의 합은 b(b+1)/2 - (a-1)a/2 = n
	// 살짝 바꾸면 b(b+1) - a(a+1) = 2n
	// 1<=b<=10000, 0<=a<10000 범위에서
	// 계산을 줄이기 위해 거꾸로 줄이면서 2n을 넘기면 continue
	// 상세한 구현은 생략

	public static int solution(int n) {
		return startHalf(n);
	}
}