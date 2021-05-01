import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1112_줄자접기 { // 제출일 2021-05-01 23:39

	static double l, r, len, r1, r2, b1, b2, y1, y2, red, blue, yellow;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// red
		l = 0;
		r = Double.parseDouble(br.readLine());
		len = r - l;

		st = new StringTokenizer(br.readLine());
		r1 = Double.parseDouble(st.nextToken());
		r2 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		b1 = Double.parseDouble(st.nextToken());
		b2 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		y1 = Double.parseDouble(st.nextToken());
		y2 = Double.parseDouble(st.nextToken());

		red = (r1 + r2) / 2;

		l = red;
		r = Math.max(r, l * 2);
		len = r - l;

		// blue
		if (b1 < red) {
			b1 = -b1 + red * 2;
		}
		if (b2 < red) {
			b2 = -b2 + red * 2;
		}
		if (y1 < red) {
			y1 = -y1 + red * 2;
		}
		if (y2 < red) {
			y2 = -y2 + red * 2;
		}

		if (b1 == b2) {
			if (y1 == y2) {
			} else {
				yellow = (y1 + y2) / 2;
				l = yellow;
				r = Math.max(r, yellow + (yellow - red));
				len = r - l;
			}
		} else {
			blue = (b1 + b2) / 2;
			l = blue;
			r = Math.max(r, blue + (blue - red));
			len = r - l;

			if (y1 < blue) {
				y1 = -y1 + blue * 2;
			}
			if (y2 < blue) {
				y2 = -y2 + blue * 2;
			}

			if (y1 == y2) {
			} else {
				yellow = (y1 + y2) / 2;
				l = yellow;
				r = Math.max(r, yellow + (yellow - blue));
				len = r - l;
			}
		}
		sb.append(String.format("%.1f", len));
		bw.write(sb.toString());
		bw.flush();

	}

}