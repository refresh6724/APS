import java.util.HashSet;
import java.util.Scanner;

public class Main_BOJ_2239_스도쿠 { // 제출일 2019-11-13 10:45
	static int N = 9;
	static int N2 = 18;
	static int N3 = 27;
	static int[][] map;
	static boolean end;
	static HashSet<Integer> sets[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(s.substring(j, j + 1));
			}
		}
		// 입력 종료

		sets = new HashSet[N3];
		// row
		for (int row = 0; row < N; row++) {
			sets[row] = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				sets[row].add(map[row][i]);
			}
		}

		// col
		for (int col = N; col < N2; col++) {
			sets[col] = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				sets[col].add(map[i][col-N]);
			}
		}

		// 3*3
		for (int sq = N2; sq < N3; sq++) {
			sets[sq] = new HashSet<Integer>();
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r < 3) {
					if (c < 3) {
						sets[N2].add(map[r][c]);
					} else if (c < 6) {
						sets[N2+1].add(map[r][c]);
					} else { // c<9
						sets[N2+2].add(map[r][c]);
					}
				} else if (r < 6) {
					if (c < 3) {
						sets[N2+3].add(map[r][c]);
					} else if (c < 6) {
						sets[N2+4].add(map[r][c]);
					} else { // c<9
						sets[N2+5].add(map[r][c]);
					}
				} else { // r<9
					if (c < 3) {
						sets[N2+6].add(map[r][c]);
					} else if (c < 6) {
						sets[N2+7].add(map[r][c]);
					} else { // c<9
						sets[N2+8].add(map[r][c]);
					}
				}		
			}
		}		
		// 검증용 set 생성

		int r = 0;
		int c = 0;
		
//		dfs2(r,c);
		
		
		for (int j = 1; j <= N; j++) {
			if (!end)
				dfs(r, c, j);
		}
			
		
	}

	private static void dfs2(int r, int c) {
		if (end)
			return;
		if (r == N) {
			end = true;
			return;
		}
		if (c == N) {
			dfs2(r + 1, 0);
			return;
		}
		if (map[r][c] != 0) { // 이미 입력되어 있다면
			dfs2(r, c + 1);
			return;
		}
		
		//

		
		//
		
		for (int input = 1; input <= N; input++) {
			if(sets[r].contains(input)) continue;
			if(sets[N+c].contains(input)) continue;
			if (r < 3) {
				if (c < 3) {
					if(sets[N2].contains(input)) continue;	
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2].remove(input);					
				} else if (c < 6) {
					if(sets[N2+1].contains(input)) continue;	
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+1].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+1].remove(input);	
				} else { // c<9
					if(sets[N2+2].contains(input)) continue;	
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+2].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+2].remove(input);	
				}
			} else if (r < 6) {
				if (c < 3) {
					if(sets[N2+3].contains(input)) continue;
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+3].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+3].remove(input);	
				} else if (c < 6) {
					if(sets[N2+4].contains(input)) continue;	
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+4].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+4].remove(input);	
				} else { // c<9
					if(sets[N2+5].contains(input)) continue;
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+5].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+5].remove(input);	
				}
			} else { // r<9
				if (c < 3) {
					if(sets[N2+6].contains(input)) continue;
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+6].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+6].remove(input);	
				} else if (c < 6) {
					if(sets[N2+7].contains(input)) continue;	
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+7].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+7].remove(input);	
				} else { // c<9
					if(sets[N2+8].contains(input)) continue;
					sets[r].add(input);
					sets[N+c].add(input);
					sets[N2+8].add(input);
					map[r][c] = input;
					dfs2(r, c+1);
					map[r][c] = 0;
					sets[r].remove(input);
					sets[N+c].remove(input);
					sets[N2+8].remove(input);	
				}
			}			
		}
		
		
		
		
		
	}

	private static void dfs(int r, int c, int input) {
		if (end)
			return;
		if (r == N) {
			end = true;
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
			return;
		}
		if (c == N) {
			dfs(r + 1, 0, input);
			return;
		}
		if (map[r][c] != 0) {
			dfs(r, c + 1, input);
			return;
		}
		// 이동 종료

		// 위치에 따른 검증
		if(sets[r].contains(input)) return;
		if(sets[N+c].contains(input)) return;
		if (r < 3) {
			if (c < 3) {
				if(sets[N2].contains(input)) return;	
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2].remove(input);		
				
			} else if (c < 6) {
				if(sets[N2+1].contains(input)) return;	
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+1].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+1].remove(input);	
			} else { // c<9
				if(sets[N2+2].contains(input)) return;	
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+2].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+2].remove(input);	
			}
		} else if (r < 6) {
			if (c < 3) {
				if(sets[N2+3].contains(input)) return;
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+3].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+3].remove(input);	
			} else if (c < 6) {
				if(sets[N2+4].contains(input)) return;	
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+4].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+4].remove(input);	
			} else { // c<9
				if(sets[N2+5].contains(input)) return;
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+5].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+5].remove(input);	
			}
		} else { // r<9
			if (c < 3) {
				if(sets[N2+6].contains(input)) return;
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+6].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+6].remove(input);	
			} else if (c < 6) {
				if(sets[N2+7].contains(input)) return;	
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+7].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+7].remove(input);	
			} else { // c<9
				if(sets[N2+8].contains(input)) return;
				sets[r].add(input);
				sets[N+c].add(input);
				sets[N2+8].add(input);
				
				map[r][c] = input;
				for (int next = 1; next <= 9; next++) {
					dfs(r, c+1, next);
				}
				map[r][c] = 0;
				sets[r].remove(input);
				sets[N+c].remove(input);
				sets[N2+8].remove(input);	
			}
		}				
		// 검증 종료
		
	}

}
