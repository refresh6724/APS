import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_190_형성평가2 { // 제출일 2021-02-05 21:50

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// "flower" "rose" "lily" "daffodil" "azalea"
		// 5개의 단어를 초기화한 후 한 개의 문자를 입력받아서
		// 입력받은 문자가 두 번째나 세 번째에 포함된 단어를 모두 출력하고
		// 마지막 줄에 출력한 단어의 개수를 출력하는 프로그램을 작성하시오.
		// 해당되는 단어가 없으면 "0"만 첫 줄에 출력한다.

		String[] arr = { "flower", "rose", "lily", "daffodil", "azalea" };
		int cnt = 0;
		char a = br.readLine().charAt(0);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(1) == a || arr[i].charAt(2) == a) {
				sb.append(arr[i]).append('\n');
				cnt++;
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
	}

}