import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14891 톱니바퀴
public class Main { // 제출일 2019-10-16 14:59

	static class Wheel {
		int num;
		int e1;
		int e2;
		int e3;
		int e4;
		int e5;
		int e6;
		int e7;
		int e8;
		int tmp;

		public Wheel(int num) {
			super();
			this.num = num;
			this.e1 = -1;
			this.e2 = -1;
			this.e3 = -1;
			this.e4 = -1;
			this.e5 = -1;
			this.e6 = -1;
			this.e7 = -1;
			this.e8 = -1;
		}

		public Wheel(int num, int e1, int e2, int e3, int e4, int e5, int e6, int e7, int e8) {
			super();
			this.num = num;
			this.e1 = e1;
			this.e2 = e2;
			this.e3 = e3;
			this.e4 = e4;
			this.e5 = e5;
			this.e6 = e6;
			this.e7 = e7;
			this.e8 = e8;
		}

		void left() {
			this.tmp = this.e1;
			this.e1 = this.e2;
			this.e2 = this.e3;
			this.e3 = this.e4;
			this.e4 = this.e5;
			this.e5 = this.e6;
			this.e6 = this.e7;
			this.e7 = this.e8;
			this.e8 = this.tmp;
		}

		void right() {
			this.tmp = this.e8;
			this.e8 = this.e7;
			this.e7 = this.e6;
			this.e6 = this.e5;
			this.e5 = this.e4;
			this.e4 = this.e3;
			this.e3 = this.e2;
			this.e2 = this.e1;
			this.e1 = this.tmp;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Wheel [num=").append(num).append(" ** ").append(e1).append(" ").append(e2).append(" ")
					.append(e3).append(" ").append(e4).append(" ").append(e5).append(" ").append(e6).append(" ")
					.append(e7).append(" ").append(e8).append("]");
			return builder.toString();
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int answer;
	static int K;
	static Wheel[] wheels;

	public static void main(String[] args) throws Exception {

		wheels = new Wheel[6];
		wheels[0] = new Wheel(0);
		for (int i = 1; i < 5; i++) {
			String str = br.readLine();
			wheels[i] = new Wheel(i, str.charAt(0) - 48, str.charAt(1) - 48, str.charAt(2) - 48, str.charAt(3) - 48,
					str.charAt(4) - 48, str.charAt(5) - 48, str.charAt(6) - 48, str.charAt(7) - 48);
		}
		wheels[5] = new Wheel(5);
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rolling(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 디버그
//			for (int j = 1; j < 5; j++) {
//				System.out.println(wheels[j]);
//			}
		}

		answer = 0;
		if (wheels[1].e1 == 1)
			answer += 1;
		if (wheels[2].e1 == 1)
			answer += 2;
		if (wheels[3].e1 == 1)
			answer += 4;
		if (wheels[4].e1 == 1)
			answer += 8;

		System.out.println(answer);
	}

	private static void rolling(int num, int dir) {
		if (num == 0 || num == 5)
			return;
		if (dir == 1) { // 시계방향 right
			if (num == 1) { // 1번이 우라면 우 좌 우 좌
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					if (wheels[num + 1].e3 + wheels[num + 2].e7 == 1) {
						if (wheels[num + 2].e3 + wheels[num + 3].e7 == 1) {
							wheels[num + 3].left();
						}
						wheels[num + 2].right();
					}
					wheels[num + 1].left();
				}
			} else if (num == 2) {
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					if (wheels[num + 1].e3 + wheels[num + 2].e7 == 1) {
						wheels[num + 2].right();
					}
					wheels[num + 1].left();
				}
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					wheels[num - 1].left();
				}
			} else if (num == 3) {
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					wheels[num + 1].left();
				}
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					if (wheels[num - 2].e3 + wheels[num - 1].e7 == 1) {
						wheels[num - 2].right();
					}
					wheels[num - 1].left();
				}
			} else if (num == 4) {
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					if (wheels[num - 2].e3 + wheels[num - 1].e7 == 1) {
						if (wheels[num - 3].e3 + wheels[num - 2].e7 == 1) {
							wheels[num - 3].left();
						}
						wheels[num - 2].right();
					}
					wheels[num - 1].left();
				}
			}
			wheels[num].right();
//			if(wheels[num-1].e3 + wheels[num].e7 == 1) rolling(num-1, -1);
//			if(wheels[num].e2 + wheels[num+1].e7 == 1) rolling(num+1, -1);
		} else {
//			if(wheels[num-1].e3 + wheels[num].e7 == 1) rolling(num-1, 1);
//			if(wheels[num].e3 + wheels[num+1].e7 == 1) rolling(num+1, 1);

			if (num == 1) { // 1번이 좌라면 좌 우 좌 우
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					if (wheels[num + 1].e3 + wheels[num + 2].e7 == 1) {
						if (wheels[num + 2].e3 + wheels[num + 3].e7 == 1) {
							wheels[num + 3].right();
						}
						wheels[num + 2].left();
					}
					wheels[num + 1].right();
				}
			} else if (num == 2) {
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					if (wheels[num + 1].e3 + wheels[num + 2].e7 == 1) {
						wheels[num + 2].left();
					}
					wheels[num + 1].right();
				}
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					wheels[num - 1].right();
				}
			} else if (num == 3) {
				if (wheels[num].e3 + wheels[num + 1].e7 == 1) {
					wheels[num + 1].right();
				}
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					if (wheels[num - 2].e3 + wheels[num - 1].e7 == 1) {
						wheels[num - 2].left();
					}
					wheels[num - 1].right();
				}
			} else if (num == 4) {
				if (wheels[num - 1].e3 + wheels[num].e7 == 1) {
					if (wheels[num - 2].e3 + wheels[num - 1].e7 == 1) {
						if (wheels[num - 3].e3 + wheels[num - 2].e7 == 1) {
							wheels[num - 3].right();
						}
						wheels[num - 2].left();
					}
					wheels[num - 1].right();
				}
			}
			wheels[num].left();
		}
	}

}
