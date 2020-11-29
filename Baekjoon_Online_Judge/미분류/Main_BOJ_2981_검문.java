import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/2981
 */
public class Main_BOJ_2981_검문 { // 제출일 2020-11-29 23:59 17164 kb 180 ms // 백준 아이디 mainlib990 님의 코드가 좋다

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 숫자 N개를 M으로 나누었을 때 나머지가 모두 같게 되는 M을 모두 찾기 
		// N 2 이상 100 이하
		// 각 원소 10억 이하 자연수
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];		
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());			
		}
		Arrays.parallelSort(num);
		int[] base = new int[n-1];
		for (int i = 0; i < n-1; i++) {
			base[i] = num[i+1] - num[0];
		}
		// 여러 수의 최소 공배수 구하기
		int GCD = base[0];
		for (int i = 1; i < n-1; i++) {
			GCD = gcd(GCD, base[i]);
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i <= (int) Math.sqrt(GCD); i++) {
			if(GCD % i == 0) {
				set.add(i);
				set.add(GCD/i);
			}
		}
		if(set.size() == 0) {
			System.out.println(GCD);			
		} else {
			int[] arr = set.stream().mapToInt(x->x).toArray();
			Arrays.parallelSort(arr);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append(GCD);
			System.out.println(sb.toString());
		}		
	}

	private static int gcd(int n, int m) {
		if(n > m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}
}
