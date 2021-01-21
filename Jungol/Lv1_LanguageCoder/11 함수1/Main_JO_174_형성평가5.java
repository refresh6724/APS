import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_174_형성평가5 { // 제출일 2021-01-21 22:27

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 3명 학생의 3과목 점수를 입력받아 각 과목별 학생별 총점을 출력하는 구조화된 프로그램을 작성하시오.

		int[][] students_scores = new int[3][4];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				students_scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		print_calc_sum(students_scores);

	}

	private static void print_calc_sum(int[][] students_scores) {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			int row_sum = 0;
			for (int col = 0; col < 3; col++) {
				row_sum += students_scores[row][col];
				sb.append(students_scores[row][col]).append(' ');
			}
			students_scores[row][3] = row_sum;
			sb.append(row_sum).append('\n');
		}
		for (int col = 0; col <= 3; col++) {
			int col_sum = 0;
			for (int row = 0; row < 3; row++) {
				col_sum += students_scores[row][col];
			}
			sb.append(col_sum).append(' ');
		}
		System.out.println(sb.toString().trim());
	}

}