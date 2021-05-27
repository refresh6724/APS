import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-08-01 19:41

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		int n = sc.nextInt();
		int[] ans = new int[n];
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j=n-1; j>=0; j--) {
			ans[j] = find(j)+1;
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static int find(int index) {
		int now = arr[index];
		for(int i=index-1; i>=0; i--) {
			if(arr[i] > now) {
				return i;
			}			
		}	
		return -1;
	}

	static class sc {
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
				}catch (IOException e) {}
			} return st.nextToken();			
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
