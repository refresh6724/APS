import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11444_피보나치수6 { // 제출일 2019-10-28 15:07
	
	static matrix2by2 answer;
	static long MOD = 1000000007L;
	static long n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		answer = new matrix2by2(1, 0, 0, 1);
		n = sc.nextLong();
		
		// (fn	)=(	1	1 )^(n-2) (	1 )
		//  fn-1	1	0			1
		if(n-2>0)
			fib(n-2);			
		if(n<3)
			answer = new matrix2by2(1, 0, 0, 1);
		System.out.println((answer.r1c1 + answer.r1c2) %MOD);
	}
	private static void fib(long n) {	
		matrix2by2 ret = new matrix2by2(1, 1, 1, 0);
		matrix2by2 ret1 = new matrix2by2(1, 1, 1, 0);
		matrix2by2 ret2 = new matrix2by2(1, 1, 1, 0);
		//int a = 0;
		//int x = 1;
		while(n>1) {
			//System.out.println("n : " + n);
			//System.out.println("a : " + a);
			//System.out.println("x : " + x);
			if(n%2==1) {
				//System.out.println("홀수 타임");
				//a += x;				
				//System.out.println("a : " + a);
				//System.out.println("x : " + x);	
				answer.multiply(ret);						
			}
			ret.multiply(ret);
//			System.out.println(ret1);
//			ret1.multiply(ret2);
//			ret2.copy(ret1);
//			System.out.println(ret1);			
			//x<<=1;
			n>>=1;
			//System.out.println("a : " + a);
			//System.out.println("x : " + x);	
			//System.out.println();
		}
		//System.out.println("n이 0이 되어 빠져나옴");
		//System.out.println("n : " + n);
		//System.out.println("x : " + x);		
		//a+=x;
		//System.out.println("리턴 a : " + a);
		answer.multiply(ret);
		//System.out.println(answer);
	}
	static class matrix2by2 {
		long r1c1;
		long r1c2;
		long r2c1;
		long r2c2;
		public matrix2by2() {
			super();
		}
		
		public matrix2by2(long r1c1, long r1c2, long r2c1, long r2c2) {
			super();
			this.r1c1 = r1c1;
			this.r1c2 = r1c2;
			this.r2c1 = r2c1;
			this.r2c2 = r2c2;
		}
		public void multiply(matrix2by2 B) {
			long t1 = (this.r1c1*B.r1c1 % MOD + this.r1c2*B.r2c1 % MOD) % MOD;
			long t2 = (this.r1c1*B.r1c2 % MOD + this.r1c2*B.r2c2 % MOD) % MOD;
			long t3 = (this.r2c1*B.r1c1 % MOD + this.r2c2*B.r2c1 % MOD) % MOD;
			long t4 = (this.r2c1*B.r1c2 % MOD + this.r2c2*B.r2c2 % MOD) % MOD;
			
			this.r1c1 = t1;
			this.r1c2 = t2;
			this.r2c1 = t3;
			this.r2c2 = t4;
		}
		
		public void copy(matrix2by2 ret1) {
			this.r1c1 = ret1.r1c1;
			this.r1c2 = ret1.r1c2;
			this.r2c1 = ret1.r2c1;
			this.r2c2 = ret1.r2c2;		
		}
		
		@Override
		public String toString() {
			return String.format("%d %d\n%d %d\n", this.r1c1, this.r1c2, this.r2c1, this.r2c2);
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
