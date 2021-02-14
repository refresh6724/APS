import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_205_형성평가1 { // 제출일 2021-02-14 20:42

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 실수 2개를 입력 받아 합계를 구하고 
		// 각각 소수 셋째 자리에서 반올림하여 둘째 자리까지 한 줄에 출력하시오.

		st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		sb.append(String.format("%.2f %.2f %.2f", a,b,a+b));	
		
		bw.write(sb.toString());
		bw.flush();
	}

}