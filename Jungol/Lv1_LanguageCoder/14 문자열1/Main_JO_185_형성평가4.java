import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_185_형성평가4 { // 제출일 2021-01-30 23:42

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 단어와 문자 한 개를 입력받아서
		// 단어에서 입력받은 문자와 같은 문자를 찾아서 그 위치를 출력하는 프로그램을 작성하시오.
		// 단어에서 첫 번째 문자의 위치는 0으로 하고
		// 찾는 문자가 여러 개일 때는 처음 나오는 위치를 출력한다.
		// 만약 찾는 문자가 없을 때는 "No"라고 출력한다.
		// 대소문자는 구별되며 단어는 100자 이하이다.

		st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		char find = st.nextToken().charAt(0);
		boolean found = false;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == find) {
				System.out.println(i);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No");
		}

//		bw.write(sb.toString());
//		bw.flush();
	}

}