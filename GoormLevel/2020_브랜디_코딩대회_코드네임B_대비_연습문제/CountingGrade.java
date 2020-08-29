import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 수능 등급 책정
 * 백분율 100% 점수와 점수들이 주어질때 각 등급별 인원수를 계산하라
 */
public class CountingGrade {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int maxScore = Integer.parseInt(br.readLine()); // 수능 점수 백분율 100%		
		int score = 0;
		
		int[] count = new int[10];
		double[] cutline = new double[10];
		cutline[0] = maxScore * 1;
		cutline[1] = maxScore * 0.96; // 4%
		cutline[2] = maxScore * 0.89; // 11%
		cutline[3] = maxScore * 0.87; // 23%
		cutline[4] = maxScore * 0.6; // 40%
		cutline[5] = maxScore * 0.4; // 60%
		cutline[6] = maxScore * 0.23; // 77%
		cutline[7] = maxScore * 0.11; // 89%
		cutline[8] = maxScore * 0.04; // 96%

		while (br.ready()) { // enter가 마지막에 없는 eof
			score = Integer.parseInt(br.readLine().trim());
			for (int i = 8; i >= 0; i--) {
				if(score < cutline[i]) {
					count[i+1]++;
					break;
				}
			}
		}
				
		for (int i = 1; i < 10; i++) {
			sb.append(i).append("등급 : ").append(count[i]).append(" 명").append('\n');
		}
		System.out.println(sb.toString());
	}

}