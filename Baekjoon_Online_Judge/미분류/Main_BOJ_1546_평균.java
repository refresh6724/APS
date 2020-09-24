import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1546_평균 { // 제출일 2020-09-24 23:14

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 최댓값 m을 100%로 두고 새로운 평균을 구하라
		// 수식으로 풀면 기존 평균값 * 100/m 이 된다
		
		int n = Integer.parseInt(br.readLine());
		double m = 0;
		double sum = 0;
		int[] score = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < score.length; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(m < score[i]) {
				m = score[i];
			}
			sum += score[i];
		}
		
		System.out.println((sum/n)*(100/m));	
		
//		bw.write(sb.toString());
//		bw.flush();
	}

}