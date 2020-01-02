import java.util.Scanner;

public class Solution_D2_1959_두개의 숫자열 { // 제출일 2020-01-02 23:49

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 두 숫자 배열의 곱의 합이 최대가 되는 경우의 값을 출력		
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int max = 0;
			
			int n = sc.nextInt();
			int m = sc.nextInt();	
			
			// 항상 n >= m인 것으로 가정하고 계산
						
			int[] A = new int[n];
			int[] B = new int[m];
						
			for(int i = 0; i<n ; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i<m ; i++) {
				B[i] = sc.nextInt();
			}
			
			int len = n;
			if(n<m) len = m;
			int[] base = new int[len];
			int[] mul = new int[len];
			int gap =0;
			
			// 계산을 n-m+1번 만큼 스타팅 역시 n-m+1번 바꾸며 0에서 n-m 까지 계산
			
			if(n<m) {
				for(int i=0; i<m; i++) {
					base[i] = B[i];					
				}
				for(int i=0; i<=m-n; i++) {			
					
					// 초기화
					gap = 0;
					for(int j=0; j<m; j++) {
						mul[j] = 0;
					}
					
					// 붙이기
					for(int j=i; j<n+i; j++) {
						mul[j] = A[j-i];
					}
					
					// 더하기
					for(int j=0; j<m; j++) {
						gap += base[j] * mul[j];
					}
					
					// 계산
					if(gap > max) max = gap;
					
				}
				
			} else if(n>m){
				for(int i=0; i<n; i++) {
					base[i] = A[i];
				}
				for(int i=0; i<=n-m; i++) {
					
					
					// 초기화
					gap = 0;
					for(int j=0; j<n; j++) {
						mul[j] = 0;
					}
					
					// 붙이기
					for(int j=i; j<m+i; j++) {
						mul[j] = B[j-i];
					}
					
					// 더하기
					for(int j=0; j<n; j++) {
						gap += base[j] * mul[j];
					}
					
					// 계산
					if(gap > max) max = gap;
				}
				
			} else {
				for(int i=0; i<n; i++) {
					max += A[i]*B[i];
				}
			}
			
			System.out.printf("#%d %d\n",tc,max);
		}

	}

}
