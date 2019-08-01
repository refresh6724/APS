import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D1_2058_자릿수더하기 { // 제출일 2019-08-01 09:17
	
	public static void main(String[] args)	{
		// TODO Auto-generated method stub
		sc.init();
		String[] strs = sc.next().split("");
		int[] arr= new int[strs.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int sum = 0;
		for(int j : arr) {
			sum += j;
		}
		System.out.println(sum);
	}
	static class sc{
		private static BufferedReader br;
		private static StringTokenizer st;
		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}
		static String readLine() {
			try {
				return br.readLine();
			} catch(IOException e) {}
			return null;
		}
		static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {}
				
			} return st.nextToken();
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
