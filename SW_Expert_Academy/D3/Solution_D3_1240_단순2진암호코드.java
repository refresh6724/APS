import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드 { // 제출일 2019-08-16 18:56
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sc.init();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);		
		
		// 테스트케이스
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			answer = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			String[] lines = new String[N];
			int cnt = 0;
			int R = 0;
			boolean isFound = false;
			// 암호코드 이외에는 0이라고 가정한다.
			// 비정상코드는 없다고 가정한다. 있다면 어떤게 정상코드인지 구분하기가 너무 어렵다
			for (int i = 0; i < N; i++) {
				lines[i] = sc.readLine();
				if (lines[i].contains("1")) {
					//isFound = true;
					R=i;
					cnt++;
				//} else if(isFound) { // 1을 발견하지 못했는데 isFound가 true라면 암호코드가 끝난것이다
				//	break;			 // 모두 다 읽고 시작해야한다		
				}
			}
			int first = 0;
			int last = 0;			
			if (cnt >= 5) { // 암호코드만 존재한다고 가정했으므로 cnt<5이면 암호가 없다
				// 마지막 줄의 마지막 1 위치를 확인
				// 예제를 보면 모든 암호코드는 0101순서이다
				last = lines[R].lastIndexOf("1");
				// 1이 첫 숫자인 경우 ~ 마지막 숫자인 경우 test
				first = last - 55;
				String[] code = new String[8];
				int[] codeNum = new int[8];
				int sum = 0;
				int test = 0;
				for (int i = 0; i < 8; i++, first+=7) {
					code[i] = lines[R].substring(first, first+7);
					codeNum[i] = map.get(code[i]);
					sum += codeNum[i];
					if(i%2 == 0) test += codeNum[i]*3;
					else test += codeNum[i];
				}
				if(test%10 == 0) { // 검증코드가 통과된 경우
					answer = sum;
				}
			}
			bw.write(String.format("#%d %d\n", tc, answer));
			bw.flush();
		}

	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() throws Exception {
			// System.setIn(new FileInputStream("input.txt"));// 테스트케이스 파일을 프로젝트 폴더에 삽입
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
