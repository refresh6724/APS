import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D1_2063_중간값찾기 { // 제출일 : 2019-07-17 17:57
	
	static void BubbleSort(int[] arr, int size){
		// 매번 가장 큰 수가 마지막에 위치하도록 
		for(int i=size-1; i>0; i--) { 
			// 처음 범위는 전체 다음 뒤에서 한칸씩 범위를 축소 
			for(int j=0; j<i; j++) {
				// 앞에서 부터 큰 수를 뒤로 보낸다
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args)	{
		
		//Scanner scan = new Scanner(System.in);				
		// N개의 입력을 받는다 
		//int N = scan.nextInt();
		//int[] input = new int[N];
		//for(int i=0; i<N; i++) {
		//	input[i] = scan.nextInt();
		//}
		//BubbleSort(input, N);	
		
		sc.init();
		int N = sc.nextInt();
		int[] arr= new int[N];
		int i=0;
		for (int j = 0; j < N; j++) {
			arr[j] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[N/2]);		
		
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
