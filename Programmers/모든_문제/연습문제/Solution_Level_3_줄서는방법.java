import java.util.Arrays;

public class Solution_Level_3_줄서는방법 {

	// test
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 1))); // 1,2,3
		System.out.println(Arrays.toString(solution(3, 2))); // 1,3,2
		System.out.println(Arrays.toString(solution(3, 3)));
		System.out.println(Arrays.toString(solution(3, 4)));
		System.out.println(Arrays.toString(solution(3, 5)));
		System.out.println(Arrays.toString(solution(3, 6)));
	}

	static boolean[] used;
	static int[] arr;
	static long[] fac;
	// next Permutaion을 k번 하기 => 20! 시간초과
	// 첫번쨰 숫자가 n-1! 번씩 반복 ex) 112233
	// 두번째 숫자는 첫번째 숫자를 제외하고 n-2! 번 반복 
    public static int[] solution(int n, long k) {
        
    	used = new boolean[n+1];
    	arr = new int[n];    	
    	fac = new long[n+1];
    	fac[0] = 1;
    	for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i-1] * i;
		}
    	dfs(0, n, k);    	
        return arr;
    }
	private static void dfs(int i, int n, long k) {
		if(n == 0) {
			return;
		}
		long mok = k / fac[n-1];
		if(fac[n-1] * mok != k) {
			mok++;
		}
		long cnt = 1;
		int j = 0;
		for (j = 1; j<= n+i; j++) {
			if(!used[j]) {				
				if(cnt == mok) {
					break;
				}
				cnt++;
			}
		}
        used[j] = true;
		arr[i] = j; // 남은 수 중 mok번째 수 
		dfs(i+1, n-1, k - fac[n-1] * (mok - 1));
	}
}