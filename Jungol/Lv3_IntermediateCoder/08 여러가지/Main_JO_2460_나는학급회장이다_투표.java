import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2460_나는학급회장이다_투표 { // 제출일 2021-04-30 23:26

	static int n;

	static class Candidate implements Comparable<Candidate> {
		int num;
		int p3;
		int p2;
		int p1;
		int sum;

		public Candidate() {
			// TODO Auto-generated constructor stub
		}

		public Candidate(int num) {
			this.num = num;
			this.p3 = 0;
			this.p2 = 0;
			this.p1 = 0;
			this.sum = 0;
		}

		private void vote(int v) {
			if (v == 1) {
				this.p1 += 1;
				this.sum += 1;
			} else if (v == 2) {
				this.p2 += 1;
				this.sum += 2;
			} else {
				this.p3 += 1;
				this.sum += 3;
			}
		}

		@Override
		public int compareTo(Candidate o) {
			if (o.sum == this.sum) {
				if (o.p3 == this.p3) {
					return o.p2 - this.p2;
				}
				return o.p3 - this.p3;
			}
			return o.sum - this.sum;
		}

		@Override
		public boolean equals(Object obj) {
			if (((Candidate) obj).sum == this.sum) {
				if (((Candidate) obj).p3 == this.p3) {
					if (((Candidate) obj).p2 == this.p2) {
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		Candidate[] candidates = new Candidate[3];
		for (int i = 0; i < 3; i++) {
			candidates[i] = new Candidate(i + 1);

		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int v = Integer.parseInt(st.nextToken());
				candidates[j].vote(v);
			}
		}

		Arrays.sort(candidates);
		if (candidates[0].equals(candidates[1])) {
			sb.append(0).append(' ').append(candidates[0].sum);
		} else {
			sb.append(candidates[0].num).append(' ').append(candidates[0].sum);
		}
		bw.write(sb.toString());
		bw.flush();
	}

}