import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
//_D4_3812_호중이의큐브색칠
public class Solution_D4_3812_호중이의큐브색칠 {

	static int X; // 100만
	static int Y;
	static int Z;
	static int A; // 중심큐브 0부터~X-1
	static int B;
	static int C;
	static int N; // 1~1000
	static long[] color;
	static StringTokenizer st;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(sc.nextLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			color = new long[N];
			// 입력 종료

			// 거리에 따라 색을 정해 칠한다
			// 거리는 직선거리이며 xyz 각 2개씩 총 6개가 영향을 받는다
			// 1차원 => 2차원 => 3차원 확장 모델

			// xyz를 내림차순으로 정렬한다
			int tmp = 0;
			if (X < Y) {
				tmp = X;
				X = Y;
				Y = tmp;
				tmp = A;
				A = B;
				B = tmp;
			}
			if (Y < Z) {
				tmp = Y;
				Y = Z;
				Z = tmp;
				tmp = B;
				B = C;
				C = tmp;
			}
			if (X < Y) {
				tmp = X;
				X = Y;
				Y = tmp;
				tmp = A;
				A = B;
				B = tmp;
			}

			// X, 0부터 A까지 A부터 X-1까지
			long[] colorX = new long[N];
			// 자기자신을 더하고
			colorX[0]++;
			// 우측 A+1 ~ X-1
			int right = X - 1 - A;
			long div = right / N;
			for (int i = 0; i < N; i++) {
				colorX[i] += div;
			}
			div = right % N;
			for (int i = 1; i <= div; i++) {
				colorX[i]++;
			}
			// 좌측 0 ~ A-1
			int left = A;
			div = left / N;
			for (int i = 0; i < N; i++) {
				colorX[i] += div;
			}
			div = left % N;
			for (int i = 1; i <= div; i++) {
				colorX[i]++;
			}

			//System.out.println(Arrays.toString(colorX));

			long[] colorY = new long[N];
			// 한 줄을 구했으므로 y축으로 넘어가서 // 자기자신을 더하고
			for (int i = 0; i < N; i++) {
				colorY[i] = colorX[i];
			}
			// 우측 B+1 ~ Y-1까지
			right = Y - 1 - B;
			div = right / N;
			long sum = div * X;
			for (int i = 0; i < N; i++) {
				colorY[i] += sum;
			}
			div = right % N;			
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= div; j++) {
					colorY[(i + j) % N] += colorX[i];
				}
			}
			// 좌측 0 ~ B-1
			left = B;
			div = left / N;
			sum = div * X;
			for (int i = 0; i < N; i++) {
				colorY[i] += sum;
			}
			div = left % N;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= div; j++) {
					colorY[(i + j) % N] += colorX[i];
				}
			}

			//System.out.println(Arrays.toString(colorY));

			// Z
			// C
			long[] colorZ = new long[N];
			for (int i = 0; i < N; i++) {
				colorZ[i] = colorY[i];
			}
			// 우측 C+1~Z-1
			right = Z - 1 - C;
			div = right / N;
			sum = div * X * Y;
			for (int i = 0; i < N; i++) {
				colorZ[i] += sum;
			}
			div = right % N;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= div; j++) {
					colorZ[(i + j) % N] += colorY[i];
				}
			}
			// 좌측 0~C-1
			left = C;
			div = left/N;
			sum = div * X * Y;
			for (int i = 0; i < N; i++) {
				colorZ[i] += sum;
			}
			div = left % N;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= div; j++) {
					colorZ[(i + j) % N] += colorY[i];
				}
			}
			

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < N; i++) {
				sb.append(colorZ[i]).append(" ");
			}
			System.out.println(sb.toString());
		}

	}

}
