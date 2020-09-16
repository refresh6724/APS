import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_10039_평균점수 { // 제출일 2020-09-16 22:55

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] score = new int[5];
		for (int i = 0; i < score.length; i++) {
			score[i] = Integer.parseInt(br.readLine());
			if(score[i] < 40) {
				score[i] = 40;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		} 
		System.out.println(sum/5);
//
//		bw.write(sb.toString());
//		bw.flush();
	}

}