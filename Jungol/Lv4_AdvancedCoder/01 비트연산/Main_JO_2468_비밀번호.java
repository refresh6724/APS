import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_2468_비밀번호 { // 제출일 2021-07-03 23:17

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long input = Long.parseLong(br.readLine().trim());
		String A = Long.toBinaryString(input);
		// A가 가지고 있는 1의 개수 x
		// A보다 작으면서 1의 개수가 x와 같은 수
		// A보다 크면서 1의 개수가 x와 같은 수
		// 가장 가까운 수를 찾고 만약 없다면 0 출력
		// 만약 10111010100001110001 이라면

		// 작은 수는 오른쪽에서 최초로 0 다음에 오는 1, 즉 가장 마지막 10을 찾아 01로 바꾸는 것
		// 또 01로 바꾸고 뒤에 있는 모든 0을 맨 뒤로 몰아준다
		// 만약 10이 없다면 (예를 들어 1111) 0 출력

		// 큰 수는 가장 마지막 01을 찾아 10으로 바꾸는 것
		// 또 10으로 바꾸고 뒤에 있는 모든 1을 맨 뒤로 몰아준다
		// 만약 01이 없다면 예를 들어 1111 인 경우 첫 1을 01 취급하여 10111로 바꾼다

		char[] B = A.toCharArray();
		int idx10 = A.lastIndexOf("10");
		if (idx10 == -1) {
			sb.append('0');
		} else {
			B[idx10++] = '0';
			B[idx10++] = '1';
			int oneCnt = 0;
			for (int i = idx10; i < B.length; i++) {
				if (B[i] == '1') {
					oneCnt++;
				}
			}
			for (int i = idx10, j = 0; j < oneCnt; j++) {
				B[i + j] = '1';
			}
			for (int i = idx10 + oneCnt; i < B.length; i++) {
				B[i] = '0';
			}
			sb.append(Long.parseLong(String.copyValueOf(B), 2));
		}
		sb.append(' ');
		char[] C = A.toCharArray();
		int idx01 = A.lastIndexOf("01");
		if (idx01 == -1) {
			C[0] = '0';
			int zeroCnt = 0;
			for (int i = 1; i < C.length; i++) {
				if (C[i] == '0') {
					zeroCnt++;
				}
			}
			for (int i = 1, j = 0; j < zeroCnt; j++) {
				C[i + j] = '0';
			}
			for (int i = 1 + zeroCnt; i < C.length; i++) {
				C[i] = '1';
			}
			sb.append(Long.parseLong("1".concat(String.copyValueOf(C)), 2));
		} else {
			C[idx01++] = '1';
			C[idx01++] = '0';
			int zeroCnt = 0;
			for (int i = idx01; i < C.length; i++) {
				if (C[i] == '0') {
					zeroCnt++;
				}
			}
			for (int i = idx01, j = 0; j < zeroCnt; j++) {
				C[i + j] = '0';
			}
			for (int i = idx01 + zeroCnt; i < C.length; i++) {
				C[i] = '1';
			}
			sb.append(Long.parseLong(String.copyValueOf(C), 2));
		}
		System.out.println(sb.toString());

	}

}