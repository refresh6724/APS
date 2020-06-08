import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

//     최초 제출일 2020-06-08 23:21 36,264 kb 170 ms
// 1차 개선 제출일 2020-06-08 23:48 25,892 kb 149 ms
public class Solution_D3_1221_GNS { 

	static HashMap<String, Integer> map = new HashMap<>();
	static String[] rev = new String[10];
	static int[] num = new int[10];

	public static void main(String[] args) throws Exception {

		rev[0] = "ZRO";
		rev[1] = "ONE";
		rev[2] = "TWO";
		rev[3] = "THR";
		rev[4] = "FOR";
		rev[5] = "FIV";
		rev[6] = "SIX";
		rev[7] = "SVN";
		rev[8] = "EGT";
		rev[9] = "NIN";

		for (int i = 0; i < 10; i++) {
			map.put(rev[i], i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			st = new StringTokenizer(br.readLine());
			bw.write(st.nextToken());
			bw.write('\n');
			sb = new StringBuilder();
//			sb.append(st.nextToken()).append('\n'); // #tc
			int n = Integer.parseInt(st.nextToken());
			// 라인 길이는 n << 2 , 끝 글자 공백
			String a = br.readLine();
			for (int i = 1; i < n<<2; i+=4) {
				switch(a.charAt(i)) {
				case 'R': // ZRO
					num[0]++;
					break;
				case 'N':
                    num[1]++;
                    break;
                case 'W':
                    num[2]++;
                    break;
                case 'H':
                    num[3]++;
                    break;
                case 'O':
                    num[4]++;
                    break;
                case 'I':
                    switch (a.charAt(i-1)) { // FIV
                    case 'F':
                        num[5]++;
                        break;
                    case 'S': // SIX
                        num[6]++;
                        break;
                    case 'N': // NIN
                        num[9]++;
                        break;
                    }
                    break;
                case 'V':
                    num[7]++;
                    break;
                case 'G':
                    num[8]++;
                    break;
                }
			}
			
			for (int i = 0; i < 10; i++) {
				while(num[i]-- != 0) { // num을 초기화하지 않아 -값이 되어버림
					sb.append(rev[i]).append(' ');
				}
			}
			Arrays.fill(num, 0);
			// ABC ABC ABC
			// 012345678901
			// 7 = 2 * 4 -1
			// sb.append(' '); 
			// #1이 계산되지 않았다
			sb.replace((n<<2)-1, (n<<2), "\n");
			bw.write(sb.toString());
			bw.flush();
		}
	}
}
