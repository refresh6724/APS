import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1229_암호문2 { // 제출일 2020-06-10 23:42 19,552 kb 102 ms
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {			
			sb.append("#").append(t);

			int L1 = Integer.parseInt(br.readLine());
			List<Integer> lst = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L1; i++) {
				lst.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어 개수
			int L3 = Integer.parseInt(br.readLine());
			// 입력 I, D, A 위치 개수N 숫자1 숫자2 ... 숫자N
			int len = 0;
			int pos = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L3; i++) {
				switch (st.nextToken()) {
				case "I":
					// 포지션
					pos = Integer.parseInt(st.nextToken());
					// 개수 N
					len = Integer.parseInt(st.nextToken());
					for (int j = 0; j < len; j++) {
						lst.add(pos + j, Integer.parseInt(st.nextToken()));
					}
					break;
				default :
					// 포지션
					pos = Integer.parseInt(st.nextToken());
					// 개수 N
					len = Integer.parseInt(st.nextToken());
					for (int j = 0; j < len; j++) {
						lst.remove(pos);
                    }
					break;
                }
			}
			
			for (int k = 0; k < 10; k++) {
				sb.append(" ").append(lst.get(k));
			}
			sb.append("\n");			
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
