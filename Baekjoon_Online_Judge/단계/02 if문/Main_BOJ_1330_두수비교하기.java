import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1330_두수비교하기 { // 제출일 2020-09-08 20:51

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(a>b) {
			System.out.println('>');
		} else if(a<b) {
			System.out.println('<');
		} else {
			System.out.println("==");
		}
	}

}