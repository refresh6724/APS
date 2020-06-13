import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1002_터렛 { // 제출일 2020-06-13 21:01 13292 kb 76 ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int answer = 0;
			// 두 점 x1,y1 x2,y2 로 부터 거리 r1, r2 떨어진 좌표 찾기
			// 원 두개가 한 점에서 만나면 1, 겹치면 2, 완전히 같은 원이라면 -1, 겹치지 않는다면 0
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // -10000 ~ 10000 위치
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken()); // 10000 이하 자연수
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int d2 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); // 2만 * 2만 = 4억 => 최대 8억
			if (d2 == 0 && r1 == r2) {				
				sb.append(-1).append('\n');		
				continue;
			}
			int ld =  (r1 + r2) * (r1 + r2);
			int sd = (r1 - r2) * (r1 - r2);
			if(sd < d2 && d2 < ld) { // 교차
				sb.append(2).append('\n');
			} else if(sd == d2 || ld == d2) {
				sb.append(1).append('\n'); // 짧은 경우 내접, 긴 경우 외접
			} else {
				sb.append(0).append('\n'); // 기타 만나지 못함
			}			
		}
		bw.write(sb.toString());
		bw.flush();
	}
}