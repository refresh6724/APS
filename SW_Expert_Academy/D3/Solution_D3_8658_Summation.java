import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_8658_Summation { // 제출일 2020-03-29 23:40
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	static int max, min;
	static int[] num;

	public static void main(String[] args) throws Exception {

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			max = 0;
			min = 0;
			num = new int[10];
			char[] numbers = br.readLine().toCharArray();
			int a = 0;
			for (int i = 0; i < numbers.length; i++) {
				
				if(numbers[i] != ' ') {
					num[a] += numbers[i]-'0';
				} else {
					a++;
				}
				
			}
			Arrays.sort(num);
//			System.out.println(Arrays.toString(num));
			max = num[9];
			min = num[0];
			
			
			sb.append("#").append(tc).append(" ").append(max).append(" ").append(min).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();

	}

}
