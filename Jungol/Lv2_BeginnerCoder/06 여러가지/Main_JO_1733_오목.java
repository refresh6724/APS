import java.util.Scanner;

public class Main_JO_1733_오목 { // 제출일 2019-11-08 11:06

	static int[][] map = new int[21][21]; // 1~19번 사용
	static int[][][] one = new int[21][21][4];
	static int[][][] two = new int[21][21][4];
	
	// 4방향 탐색		좌하향, 우향, 우하향, 하향
	static int[] dr = {1, 0, 1, 1};
	static int[] dc = {-1, 1, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					continue;
				} else if(map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						two[i][j][k]=0;
						one[i][j][k]++;
						one[i+dr[k]][j+dc[k]][k]+=one[i][j][k];
					}
				} else if (map[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						one[i][j][k]=0;
						two[i][j][k]++;
						two[i+dr[k]][j+dc[k]][k]+=two[i][j][k];
					}
				}
				
			}
		}
		
		
//		for (int i = 1; i < 20; i++) {
//			for (int j = 1; j < 19; j++) {
//				System.out.print(two[i][j][3]+" ");
//			}
//			System.out.println();
//		}
//		
		
			
		
		boolean find = false;
		loop:
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				// 5목이 있으면 6목을 확인하고 없다면 출력
				for (int k = 0; k < 4; k++) {
					if(one[i][j][k] == 5 && one[i+dr[k]][j+dc[k]][k] != 6) {
						find = true;
						if(k == 0) { 
							System.out.printf("1\n%d %d", i, j);							
						} else if (k == 1) {
							System.out.printf("1\n%d %d", i, j-4);
						} else if (k == 2) {
							System.out.printf("1\n%d %d", i-4, j-4);
						} else if (k == 3) {
							System.out.printf("1\n%d %d", i-4, j);
						}
						break loop;
					} else if(two[i][j][k] == 5 && two[i+dr[k]][j+dc[k]][k] != 6) {
						find = true;
						if(k == 0) { 
							System.out.printf("2\n%d %d", i, j);							
						} else if (k == 1) {
							System.out.printf("2\n%d %d", i, j-4);
						} else if (k == 2) {
							System.out.printf("2\n%d %d", i-4, j-4);
						} else if (k == 3) {
							System.out.printf("2\n%d %d", i-4, j);
						}
						break loop;
					} 
				}
			}
		}
		if(!find) System.out.println(0);
		
		
	}
	
}
