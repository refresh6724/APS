import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 { // 제출일 2019-09-05 15:11
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder answer;
	static int H; // 2이상 20이하 높이
	static int W; // 2이상 20이하 너비
	static char[][] map;
	static int TX;
	static int TY;
	static int N; // 100이하 자연수
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][];
			TX = -1;
			TY = -1;
			for (int row = 0; row < H; row++) {
				map[row] = sc.next().toCharArray();
				//System.out.println(map[row]);
				if(TX == -1) {
					for (int j = 0; j < W; j++) {					
						if(map[row][j] == '^' || map[row][j] == 'v' || map[row][j] == '<' || map[row][j] == '>') {
							TX = row;
							TY = j;
						}
					}
				}				
			}
			//System.out.println(map[2][1]);
			//System.out.println(map[2][1] == '<');
			/*
				. 평지(전차가 들어갈 수 있다.) 
				* 벽돌로 만들어진 벽 
				# 강철로 만들어진 벽 
				- 물(전차는 들어갈 수 없다.) 
				^ 위쪽을 바라보는 전차(아래는 평지이다.) 
				v 아래쪽을 바라보는 전차(아래는 평지이다.) 
				< 왼쪽을 바라보는 전차(아래는 평지이다.) 
				> 오른쪽을 바라보는 전차(아래는 평지이다.) 
			 */
			/*
				U Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다. 
				D Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다. 
				L Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다. 
				R Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다. 
				S Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다. 
			 */
			
			
			
			N = sc.nextInt(); // 입력 수
			char[] orders = sc.next().toCharArray();
			for (int i = 0; i < N; i++) {
				switch(orders[i]) {
				case 'U' :					
					if(TX-1>=0 && map[TX-1][TY] == '.') {
						map[TX-1][TY] = '^';
						map[TX][TY] = '.';
						TX--;
					} else {
						map[TX][TY] = '^';
					}
					break;
				case 'D' :
					if(TX+1<H && map[TX+1][TY] == '.') {
						map[TX+1][TY] = 'v';
						map[TX][TY] = '.';
						TX++;
					} else {
						map[TX][TY] = 'v';
					}
					break;
				case 'L' :
					if(TY-1>=0 && map[TX][TY-1] == '.') {
						map[TX][TY-1] = '<';
						map[TX][TY] = '.';
						TY--;
					} else {
						map[TX][TY] = '<';
					}
					break;
				case 'R' :
					if(TY+1<W && map[TX][TY+1] == '.') {
						map[TX][TY+1] = '>';
						map[TX][TY] = '.';
						TY++;
					} else {
						map[TX][TY] = '>';
					}
					break;
				case 'S' :
					int tx = TX;
					int ty = TY;
					switch(map[tx][ty]) {
					case '^':
						while(--tx != -1) {
							if(map[tx][ty] == '.' || map[tx][ty] == '-') {
								continue;
							} else if(map[tx][ty] == '#') {
								break;
							} else if(map[tx][ty] == '*') {
								map[tx][ty] = '.';
								break;
							}
						}
						tx = TX;
						break;
					case 'v':
						while(++tx != H) {
							if(map[tx][ty] == '.' || map[tx][ty] == '-') {
								continue;
							} else if(map[tx][ty] == '#') {
								break;
							} else if(map[tx][ty] == '*') {
								map[tx][ty] = '.';
								break;
							}
						}
						tx = TX;
						break;
					case '<':
						while(--ty != -1) {
							if(map[tx][ty] == '.' || map[tx][ty] == '-') {
								continue;
							} else if(map[tx][ty] == '#') {
								break;
							} else if(map[tx][ty] == '*') {
								map[tx][ty] = '.';
								break;
							}
						}
						ty = TY;
						break;
					case '>':
						while(++ty != W) {
							if(map[tx][ty] == '.' || map[tx][ty] == '-') {
								continue;
							} else if(map[tx][ty] == '#') {
								break;
							} else if(map[tx][ty] == '*') {
								map[tx][ty] = '.';
								break;
							}
						}
						ty = TY;
						break;						
					}
					break;						
				}
				
				// 디버그
				/*
				answer = new StringBuilder();
				for (int j = 0; j < H; j++) {
					for (int k = 0; k < W; k++) {
						answer.append(map[j][k]);
					}
					answer.append("\n");
				}
				
				System.out.println(answer);
				*/
				
			}
			
			answer = new StringBuilder();
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					answer.append(map[i][j]);
				}
				answer.append("\n");
			}
			
			bw.write(String.format("#%d %s\n", tc, answer));
			bw.flush();
		}
		
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
