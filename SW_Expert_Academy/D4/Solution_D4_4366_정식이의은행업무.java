import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_4366_정식이의은행업무 { // 제출일 2019-09-25 18:01
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			// 2진수의 합에서 길이-1번을 돌면서 1<<i를 뺀 값이
			// 3의 배수라면 그 값을 3진수로 변환하여 매 자리수를 비교하여 단 한자리만이 다르다면 그 값이 정답이다

			//String two = sc.next();
			char[] two = sc.next().toCharArray();
			//String three = sc.next();
			char[] three = sc.next().toCharArray();
			
			long binarysum = 0;
			long ternarysum = 0;
			int twosize = two.length;
			int threesize = three.length;

			// 2진수 값
			for (int i = 0; i < twosize; i++) {
				if (two[i] == 1)
					binarysum += 1 << i;
			}
			// 하나씩 바꿔본 값
			StringBuilder sb;
			String[] nTwo = new String[twosize];
			for (int i = 0; i < twosize; i++) {
				sb = new StringBuilder();
				if(two[i] == '0') {
					two[i] = '1';
					nTwo[i] = sb.append(two).toString();
					//System.out.println(nTwo[i]);					
					two[i] = '0'; // 다시 바꿔준다
				} else if(two[i] == '1') {
					two[i] = '0';
					nTwo[i] = sb.append(two).toString();
					//System.out.println(nTwo[i]);	
					two[i] = '1';// 다시 바꿔준다
				}					
			}

			// 주어진 3진수 합
			for (int i = 0; i < threesize; i++) {
				if (three[threesize-i-1] == '2') {
					ternarysum += Math.pow(3, i)*2;		
					//System.out.println(ternarysum);
				}
				else if (three[threesize-i-1] == '1') {
					ternarysum += Math.pow(3, i);
					//System.out.println(ternarysum);
				}				
				else {
					
				}
			}

			// 0이면 1로 바꿔도 보고 2로도 바꿔보고
			// 1이면 0 또는 2로
			// 2면 0또는 1로
			test:
			for (int i = 0; i < threesize; i++) { // 값을 1-0 바꿀 위치
				if (three[threesize-i-1] == '2') {
					// 빼고 확인
					ternarysum -= Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					
					// 빼고 확인
					ternarysum -= Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					// 다시 더해줌
					ternarysum += Math.pow(3, i)*2;
				} else if (three[threesize-i-1] == '1') {
					// 빼고 확인
					ternarysum -= Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					// 다시 더해줌
					ternarysum += Math.pow(3, i);
					// 더해서 확인
					ternarysum += Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					// 다시 빼줌
					ternarysum -= Math.pow(3, i);
				} else {
					// 더해서 확인
					ternarysum += Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					// 더해서 확인
					ternarysum += Math.pow(3, i);
					for (int j = 0; j < nTwo.length; j++) {
						if(Long.toBinaryString(ternarysum).equals(nTwo[j])){
							// 정답
							answer = ternarysum;
							break test;
						}
					}
					// 다시 빼줌
					ternarysum -= Math.pow(3, i)*2;
				}
			}

			bw.write(String.format("#%d %d\n", tc, answer));
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
