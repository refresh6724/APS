import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 { // 제출일 2020-01-01 23:34

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 달팽이 숫자 출력
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = 0;
				}				
			}
			int r = 0;
			int c = 0;
			int number = 1;
			int nr = 0;
			int nc = 0;
			
			while(number != n*n +1) {
			
				while(nr<n && nr >=0 && nc <n && nc >=0 && map[nr][nc] == 0){ // 해당 값이 범위 내라면
					map[nr][nc] = number; // 우측으로
					nc++;
					number++;
				}
				nc--;
				nr++;
				while(nr<n && nr >=0 && nc <n && nc >=0&& map[nr][nc] == 0){ // 해당 값이 범위 내라면
					map[nr++][nc] = number++; // 아래로
				}
				nr--;
				nc--;
				while(nr<n && nr >=0 && nc <n && nc >=0 && map[nr][nc] == 0){ // 해당 값이 범위 내라면
					map[nr][nc--] = number++; // 좌측
				}
				nc++;
				nr--;
				while(nr<n && nr >=0 && nc <n && nc >=0 && map[nr][nc] == 0){ // 해당 값이 범위 내라면
					map[nr--][nc] = number++; // 위로
				}
				nr++;
				nc++;
			}
						
			System.out.printf("#%d\n",tc);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.printf("%d ",map[i][j]);
				}
				System.out.println();
			}
			
		}

	}

}
