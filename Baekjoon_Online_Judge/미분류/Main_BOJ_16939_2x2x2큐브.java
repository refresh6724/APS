import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 백준 16939번 2*2*2큐브
public class Main { // 제출일 2019-10-14 14:09
	
	static int[][] map;
	static int pace;
	static int color;
	static int[] n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		pace = 4;
		color = 6;
		// 입력 순서
		//	0	0	1	2	0	0	0	0	
		//	0	0	3	4	0	0	0	0	
		//	13	14	5	6	17	18	21	22
		//	15	16	7	8	19	20	23	24
		//	0	0	9	10	0	0	0	0
		//	0	0	11	12	0	0	0	0
		
		// 루빅스 큐브를 정확히 한 번 돌려서 풀 수 있으면 1, 없으면 0을 출력한다
		
		// 3,4라인을 기준으로 좌우로 돌리므로
		// 따라서 다음 경우의 수를 확인하면 된다 
		
		//	15	13	1	2	18	20	12	11	
		//	16	14	3	4	17	19	10	9	
		//	0	0	5	6	0	0	0	0
		//	0	0	7	8	0	0	0	0
		//	0	0	0	0	0	0	21	22
		//	0	0	0	0	0	0	23	24
		
		//	0	0	0	0	0	0	21	22	
		//	0	0	0	0	0	0	23	24	
		//	0	0	5	6	0	0	0	0
		//	0	0	7	8	0	0	0	0
		//	14	16	9	10	19	17	4	3
		//	13	15	11	12	20	18	2	1			
			
		//	0	0	13	14	0	0	0	0	
		//	0	0	15	16	0	0	0	0	
		//	2	4	6	8	10	12	23	21
		//	1	3	5	7	9	11	24	22
		//	0	0	17	18	0	0	0	0
		//	0	0	19	20	0	0	0	0
		
		
		int total = pace * color;
		n = new int[total +1];
		for (int i = 1; i <= total; i++) {
			n[i] = sc.nextInt();
		}
		
		boolean isCan = false;
		for (int i = 1; i <= 16; i++) { // 각 라인에 대해 좌 우 각 1회
			isCan = test(i);
			if(isCan) break;
		}
		
		if(isCan) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static boolean test(int i) {
		
		map = new int[6][8];		
		if(i <= 4) {
			map[0][0] = n[15];
			map[0][1] = n[13];
			map[0][2] = n[1];
			map[0][3] = n[2];
			map[0][4] = n[18];
			map[0][5] = n[20];
			map[0][6] = n[12];
			map[0][7] = n[11];			
			
			map[1][0] = n[16];
			map[1][1] = n[14];
			map[1][2] = n[3];
			map[1][3] = n[4];
			map[1][4] = n[17];
			map[1][5] = n[19];
			map[1][6] = n[10];
			map[1][7] = n[9];
			
			map[2][0] = 0;
			map[2][1] = 0;
			map[2][2] = n[5];
			map[2][3] = n[6];
			map[2][4] = 0;
			map[2][5] = 0;
			map[2][6] = 0;
			map[2][7] = 0;
			
			map[3][0] = 0;
			map[3][1] = 0;
			map[3][2] = n[7];
			map[3][3] = n[8];
			map[3][4] = 0;
			map[3][5] = 0;		
			map[3][6] = 0;
			map[3][7] = 0;
			
			map[4][0] = 0;
			map[4][1] = 0;
			map[4][2] = 0;
			map[4][3] = 0;
			map[4][4] = 0;
			map[4][5] = 0;		
			map[4][6] = n[21];
			map[4][7] = n[22];
			
			map[5][0] = 0;
			map[5][1] = 0;
			map[5][2] = 0;
			map[5][3] = 0;
			map[5][4] = 0;
			map[5][5] = 0;		
			map[5][6] = n[23];
			map[5][7] = n[24];
			
		} else if (i <= 8) {
			map[0][0] = 0;
			map[0][1] = 0;
			map[0][2] = n[1];
			map[0][3] = n[2];
			map[0][4] = 0;
			map[0][5] = 0;
			map[0][6] = 0;
			map[0][7] = 0;			
			
			map[1][0] = 0;
			map[1][1] = 0;
			map[1][2] = n[3];
			map[1][3] = n[4];
			map[1][4] = 0;
			map[1][5] = 0;
			map[1][6] = 0;
			map[1][7] = 0;
			
			map[2][0] = n[13];
			map[2][1] = n[14];
			map[2][2] = n[5];
			map[2][3] = n[6];
			map[2][4] = n[17];
			map[2][5] = n[18];
			map[2][6] = n[21];
			map[2][7] = n[22];
			
			map[3][0] = n[15];
			map[3][1] = n[16];
			map[3][2] = n[7];
			map[3][3] = n[8];
			map[3][4] = n[19];
			map[3][5] = n[20];		
			map[3][6] = n[23];
			map[3][7] = n[24];
			
			map[4][0] = 0;
			map[4][1] = 0;
			map[4][2] = n[9];
			map[4][3] = n[10];
			map[4][4] = 0;
			map[4][5] = 0;		
			map[4][6] = 0;
			map[4][7] = 0;
			
			map[5][0] = 0;
			map[5][1] = 0;
			map[5][2] = n[11];
			map[5][3] = n[12];
			map[5][4] = 0;
			map[5][5] = 0;		
			map[5][6] = 0;
			map[5][7] = 0;
			
		} else if (i <= 12) {
            return false;
			
		} else if (i <= 16) {
			map[0][0] = 0;
			map[0][1] = 0;
			map[0][2] = n[13];
			map[0][3] = n[14];
			map[0][4] = 0;
			map[0][5] = 0;
			map[0][6] = 0;
			map[0][7] = 0;			
			
			map[1][0] = 0;
			map[1][1] = 0;
			map[1][2] = n[15];
			map[1][3] = n[16];
			map[1][4] = 0;
			map[1][5] = 0;
			map[1][6] = 0;
			map[1][7] = 0;
			
			map[2][0] = n[2];
			map[2][1] = n[4];
			map[2][2] = n[6];
			map[2][3] = n[8];
			map[2][4] = n[10];
			map[2][5] = n[12];
			map[2][6] = n[23];
			map[2][7] = n[21];
			
			map[3][0] = n[1];
			map[3][1] = n[3];
			map[3][2] = n[5];
			map[3][3] = n[7];
			map[3][4] = n[9];
			map[3][5] = n[11];		
			map[3][6] = n[24];
			map[3][7] = n[22];
			
			map[4][0] = 0;
			map[4][1] = 0;
			map[4][2] = n[17];
			map[4][3] = n[18];
			map[4][4] = 0;
			map[4][5] = 0;				
			map[4][6] = 0;
			map[4][7] = 0;
			
			map[5][0] = 0;
			map[5][1] = 0;
			map[5][2] = n[19];
			map[5][3] = n[20];
			map[5][4] = 0;
			map[5][5] = 0;		
			map[5][6] = 0;
			map[5][7] = 0;
			
			
		} else {
			System.out.println("Err");
		}
		
		// 디버그
//		System.out.println("==========이동 전============");
//		for (int j = 0; j < 6; j++) {
//			System.out.println(Arrays.toString(map[j]));
//		}
//		System.out.println();	
		
		// 입력 종료 
		// 칸 이동
		int line = (i-1)/2;
		if(i>12) line = 3;
		else if(i>14) line = 4;
		// (i-1)/2 라인을 i%2를 사용해 0이면 좌 1이면 우로 이동 
		int tmp1 = 0;
		int tmp2 = 0;
		if(i%2==0) {
			tmp1 = map[line][0];
			tmp2 = map[line][1];
			
			map[line][0] = map[line][2];
			map[line][1] = map[line][3];
			
			map[line][2] = map[line][4];
			map[line][3] = map[line][5];
			
			map[line][4] = map[line][6];
			map[line][5] = map[line][7];
			
			map[line][6] = tmp1;
			map[line][7] = tmp2;
		} else {
			tmp1 = map[line][6];
			tmp2 = map[line][7];
			
			map[line][6] = map[line][4];
			map[line][7] = map[line][5];
			
			map[line][4] = map[line][2];
			map[line][5] = map[line][3];
			
			map[line][2] = map[line][0];
			map[line][3] = map[line][1];
			
			map[line][0] = tmp1;
			map[line][1] = tmp2;
		}
		
		// 디버그
//		System.out.println("==========이동 후============");		
//		for (int j = 0; j < 6; j++) {
//			System.out.println(Arrays.toString(map[j]));
//		}
//		System.out.println();
		
		// 체크
		// 6행 8열에 대해 각 2*2 씩 같은 숫자인지 체크
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 4; k++) {
				if(map[2*j][2*k] == 0) continue;
				if(map[2*j][2*k] == map[2*j][2*k+1]
						&& map[2*j+1][2*k] == map[2*j+1][2*k+1]
								&& map[2*j][2*k+1] == map[2*j+1][2*k]) {
					
				} else {
					return false;
				}
			}
		}
		
		// 디버그
//		for (int j = 0; j < 6; j++) {
//			System.out.println(Arrays.toString(map[j]));
//		}
		return true;	
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
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();

		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static long nextLong() {
			return Long.parseLong(next());
		}
	}
}
