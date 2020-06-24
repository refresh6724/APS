
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Solution_D3_3131_100만이하의모든소수 { // 제출일 2020-06-24 22:51 25,628 kb 162 ms

	static boolean[] arr = new boolean[1000000];

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 2 3 ... 999983
		// 100만 배열
		// 2의 배수를 지우고 3의 배수를 지우고 ...

		for (int i = 2; i <= 999983; i++) {
			if (!arr[i]) {				
				bw.write(Integer.toString(i));
				bw.write(' ');
				for (int j = i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		bw.write('\n');
		bw.flush();
	}
}