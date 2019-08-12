import java.util.Scanner;

public class Solution_D3_8104_조만들기 { // 제출일 2019-08-13 01:14

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc);
			arr = new int[21]; //1번부터 20번 사용			
			int N = sc.nextInt();
			int K = sc.nextInt();
			for (int i = 1; i <= N; i++) { // N명
				if(i%2 == 1) {
					for (int j = 1; j <= K; j++) {
						arr[j] += (i-1)*K +j;
					}
				} else {
					for (int j = 1; j <=K; j++) {
						arr[j] += i*K -j+1;
					}
				}				
			}
			for (int i = 1; i <= K; i++) {
				sb.append(" ").append(arr[i]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
