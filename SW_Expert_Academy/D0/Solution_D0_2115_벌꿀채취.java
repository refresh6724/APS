import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.FontUIResource;

public class Solution_D0_2115_벌꿀채취 { // 제출일 2020-02-28 15:43
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m, c;
	static int[][] input;
	static int[][] subMax;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test_case = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= test_case;i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			input = new int[n][n];
			subMax = new int[n][n-m+1];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					input[j][k] = Integer.parseInt(st.nextToken());
				}
			}		
			// 1인 최대 수확량 계산
			calc();
			
			// 2명 조합할 때 최대인 값			
			System.out.println("#"+i+" "+getMax());
		}
		
		
		
	}

	private static int getMax() {
		int max = 0;
		int temp = 0;
		int temp2 = 0;
		
		int[] rowMax = new int[n+1]; // 마지막 n은 0을 사용
		for (int i = 0; i < n; i++) {
			temp = 0;
			for (int j = 0; j <= n-m; j++) {
				if(subMax[i][j] > temp) temp = subMax[i][j];
			}
			rowMax[i] = temp; // 개별 행 최대값 저장
		}
		
		// 누적 최대값 갱신
		for (int i = n-2; i > 0; i--) { // 0은 사용하지 않기 때문에 제외
			if(rowMax[i] < rowMax[i+1]) {
				rowMax[i] = rowMax[i+1];
			}
		}
			
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j <= n-m; j++) {
				temp = 0;
				for (int k = j+m; k <= n-m; k++) {
					// i,j로 선택되는 값 + 같은 행에서 최댓값이 나오는 경우
					if(temp < subMax[i][k]) temp = subMax[i][k];
				}			
				
				// i,j로 선택되는 값 + 아래 행에서 최댓값이 나오는 경우
				temp2 = Math.max(subMax[i][j] + temp, subMax[i][j]+rowMax[i+1]);
				max = Math.max(max, temp2);
			}
		}
		
		
		return max;
	}

	private static void calc() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n-m; j++) {
				makeMaxSubset(i,j,0,0,0);
			}
		}
	}

	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if(sum>c) return;
		if(cnt == m) {
			if(subMax[i][j-m] < powSum) {
				subMax[i][j-m] = powSum;
			}
			return;
		}
		
		// i,j 위치의 원소를 제곱 값을 더할 부분 집합에 넣는다
		makeMaxSubset(i,j+1,cnt+1, sum+input[i][j], powSum+input[i][j]*input[i][j]);
		// 넣지 않는다
		makeMaxSubset(i,j+1,cnt+1, sum, powSum);
	}

	
	
	

	
}