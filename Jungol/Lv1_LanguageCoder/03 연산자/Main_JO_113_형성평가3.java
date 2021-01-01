import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_113_형성평가3 { // 제출일 2021-01-01 23:31

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int garo = Integer.parseInt(st.nextToken());
		int sero = Integer.parseInt(st.nextToken());

		garo += 5;
		sero *= 2;

		System.out.println(String.format("width = %d", garo));
		System.out.println(String.format("length = %d", sero));
		System.out.println(String.format("area = %d", garo * sero));
	}
}