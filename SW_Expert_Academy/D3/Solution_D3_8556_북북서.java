import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_8556_북북서 { // 제출일 2020-05-06 00:44 18,964 kb 92 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

//			char[] input = br.readLine().replace("north", "n").replace("west", "w").toCharArray();
//			String input = br.readLine().replace("north", "n").replace("west", "w");
			char[] input = br.readLine().toCharArray();

//			int len = input.length-1;
//			int len = input.length() - 1;
			int len = 0;

//			int 분자 = input[len]=='n'?0:90;
//			int 분자 = input.charAt(len) == 'n' ? 0 : 90;
			int 분자 = input[input.length - 4] == 'w' ? 90 : 0;
			for (int i = input.length - 6; i >= 0; i--) {
				switch (input[i]) {
				case 'w':
					분자 <<= 1;
					분자 += 90;
					len++;
					break;
				case 'n':
					분자 <<= 1;
					분자 -= 90;
					len++;
					break;
				}
			}

//			while (len-- != 0) {
//				분자 <<= 1;
////				switch(input[len]) {
//				switch (input.charAt(len)) {
//				case 'w':
//					분자 += 90;
//					break;
//
//				case 'n':
//					분자 -= 90;
//					break;
//				}
//			}

			if (len != 0) {
				// 약분
				int 분모 = 1 << (len);
//				int g = gcd(분자, 분모);
//				분자 /= g;
//				분모 /= g;

				while (분모 != 1) {
					if (분자 % 2 != 0) {
						break;
					}
					분모 >>= 1;
					분자 >>= 1;
				}

				if (분모 == 1) {
					sb.append("#").append(tc).append(" ").append(분자).append("\n");
				} else {
					sb.append("#").append(tc).append(" ").append(분자).append("/").append(분모).append("\n");
				}
			} else {
				sb.append("#").append(tc).append(" ").append(분자).append("\n");
			}

		}
		bw.write(sb.toString());
		bw.flush();

	}

//	private static int gcd(int a, int b) {
//		int tmp = 0;
//		if (a < b) {
//			tmp = a;
//			a = b;
//			b = tmp;
//		}
//		while (b != 0) {
//			tmp = b;
//			b = a % b;
//			a = tmp;
//		}
//		return a;
//	}

}
