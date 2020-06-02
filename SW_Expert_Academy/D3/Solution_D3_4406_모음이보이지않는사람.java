import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 기존 제출일 2020-06-02 23:43 18,864 kb 105 ms
// 개선 제출일 2020-06-03 02:04 19,472 kb 93 ms
public class Solution_D3_4406_모음이보이지않는사람 { 

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int r = 0, tc = 1;
		while (ir.read() != 10) { // 첫라인 넘기기, tc를 받을 필요 없음
		}

		t: while (true) {
			bw.write('#');
			bw.write(Integer.toString(tc++));
			bw.write(' ');
			i: while (true) {
				r = ir.read();
				switch (r) {
				case -1: // eof
					break t;
				case 10: // line feed (no carriage return in linux)
					bw.write('\n');
					break i;
				case 97: // a
				case 101: // e
				case 105: // i
				case 111: // o
				case 117: // u
					break;
				default:
					bw.write(r);
				}
			}
		}
		bw.flush();
	}
}