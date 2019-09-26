import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 { // 제출일 : 2019-09-26 14:43
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer  = 0;
			int p = sc.nextInt(); // 주어진 들여쓰기 된 라인 수 // 최대 10줄
			int q = sc.nextInt(); // 들여쓰기 해야하는 라인 수
			// 정답에 q번 들여쓰기 숫자를 출력
			// 명확하지 않다면 -1

			// 1이상 20이하
			// R,C,S의 계수
			int a; // 라운드 커브 ( )
			int b; // 컬리 커브 { }
			int c; // 스퀘어 브라켓 [ ]
			int d;
			int e;
			int f;
			int indent; // 들여쓰기 수
						// 공식

			// R(a-b) + C(c-d) + S(e-f)

			// 1단계 주어진 코드를 통해 R C S를 구하기
			// x y z 를 변수로 두고 1차 또는 2차 또는 3차 미지수 방정식을 풀게 된다
			OpenBracket[] openBracket = new OpenBracket[p];
			String[] input = new String[p];
			char[][] characters = new char[p][];
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			f = 0;
			for (int i = 0; i < p; i++) {
				
				input[i] = sc.readLine();
				characters[i] = input[i].toCharArray();
				indent = 0;
				// . 이 아닌 문자가 나오는 순간이 들여쓰기 수
				for (int j = 0; j < characters[i].length; j++) {
					if (characters[i][j] != '.') {
						indent = j;
						break;
					}
				}
				for (int j = 0; j < characters[i].length; j++) {
					if (characters[i][j] == '(') {
						a++;
					} else if (characters[i][j] == '{') {
						b++;
					} else if (characters[i][j] == '[') {
						c++;
					} else if (characters[i][j] == ')') {
						d++;
					} else if (characters[i][j] == '}') {
						e++;
					} else if (characters[i][j] == ']') {
						f++;
					}
				}
				openBracket[i] = new OpenBracket(indent, a, b, c, d, e, f);
			} // 각 라인에서 들여쓰기 수와 열려있는 수를 알았으므로 풀기 시작
			
			int[][] eq = new int[p-1][4];
			
			for (int i = 0; i < p-1; i++) {
				//System.out.println(openBracket[i]);
				OpenBracket o = openBracket[i];
				OpenBracket n = openBracket[i+1];
				// 디버그
//				System.out.println(String.format("R(a-b)+C(c-d)+S(e-f) = %d R+ %d C+ %d S = %d"
//						, (o.round-o.cr), (o.curly-o.cc) , (o.square-o.cs), n.indentation));
				eq[i][0]= (o.round-o.cr);
				eq[i][1]= (o.curly-o.cc);
				eq[i][2]= (o.square-o.cs);
				eq[i][3]= n.indentation;						
			}
			
			
			
			// R C S는 20이하 자연수이므로 brute 역시 가능하다 
			// 단 ,-1 출력시 조건이 있으므로 해가 2개 이상일 경우 -1이라 생각할 수 있다			
			int R, C, S;
			LinkedList<int[]> ansArr = new LinkedList<>();
			
			int ans=0; // 답이 될 수 있는 개수
			for ( R = 1; R <= 20; R++) {
				for ( C = 1; C <= 20; C++) {
					for ( S = 1; S <= 20; S++) {
						boolean isWrong = false;
						for (int i = 0; i < p-1; i++) {
							if(eq[i][0] == 0 && eq[i][1] == 0 &&eq[i][2] == 0 ) {
								// 0 0 0의 해는 무한이므로 넘긴다
								continue;
							}
							if(R*eq[i][0] + C*eq[i][1] + S*eq[i][2] != eq[i][3]) {
								// 모든 식에 대해 답이 맞지 않는다면 틀린 답이다
								isWrong = true;								
							} 
						}						
						if(!isWrong) {
							ans++;
							ansArr.add(new int[] {R,C,S});
							//System.out.println(String.format("%d %d %d", R, C, S));
							
						}						
					}
				} 
			}		

			// 2단계 R C S를 적용시키기
			OpenBracket[] openBracket2 = new OpenBracket[q];
			String[] output = new String[q];
			char[][] characters2 = new char[q][];
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			f = 0;
			for (int i = 0; i < q; i++) {
				//System.out.println("debug1");
				output[i] = sc.readLine();
				characters2[i] = output[i].toCharArray();
				indent = 0;
				
				for (int j = 0; j < characters2[i].length; j++) {
					if (characters2[i][j] == '(') {
						a++;
					} else if (characters2[i][j] == '{') {
						b++;
					} else if (characters2[i][j] == '[') {
						c++;
					} else if (characters2[i][j] == ')') {
						d++;
					} else if (characters2[i][j] == '}') {
						e++;
					} else if (characters2[i][j] == ']') {
						f++;
					}
				}
				openBracket2[i] = new OpenBracket(indent, a, b, c, d, e, f);
			} // 각 라인에서 들여쓰기 수와 열려있는 수를 알았으므로 풀기 시작
			
			
			for (int i = 0; i < q-1; i++) {
				//System.out.println(openBracket[i]);
				OpenBracket o = openBracket2[i];
				OpenBracket n = openBracket2[i+1];
				HashMap<Integer, Integer> list = new HashMap<>();
				int thistime = 0;
				for (int j = 0; j < ansArr.size(); j++) {
					thistime = ansArr.get(j)[0]*(o.round-o.cr)
							+ ansArr.get(j)[1]*(o.curly-o.cc) 
							+ ansArr.get(j)[2]*(o.square-o.cs);	
					list.put(thistime, thistime);
				}
				if(list.size() != 1) {
					n.indentation = -1;
				} else {
					n.indentation = list.get(thistime);
				}
				
			}
			
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int i = 0; i < q; i++) {
				//System.out.println(" asdf ");
				sb.append(" ").append(openBracket2[i].indentation);
			}
			sb.append("\n");
			
			bw.write(sb.toString());
			bw.flush();
		}

	}

	static class OpenBracket {
		int indentation;
		int round;
		int curly;
		int square;
		int cr;
		int cc;
		int cs;

		public OpenBracket() {
			// TODO Auto-generated constructor stub
		}

		public OpenBracket(int indentation, int round, int curly, int square, int cr, int cc, int cs) {
			super();
			this.indentation = indentation;
			this.round = round;
			this.curly = curly;
			this.square = square;
			this.cr = cr;
			this.cc = cc;
			this.cs = cs;
		}

		@Override
		public String toString() {
			return "OpenBracket [indentation=" + indentation + ", round=" + round + ", curly=" + curly + ", square="
					+ square + ", cr=" + cr + ", cc=" + cc + ", cs=" + cs + "]";
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
