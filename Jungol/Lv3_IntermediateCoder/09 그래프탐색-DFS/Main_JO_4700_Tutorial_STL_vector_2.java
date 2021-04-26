import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_JO_4700_Tutorial_STL_vector_2 { // 제출일 2021-04-26 18:38

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		Stack<Integer> stq = new Stack<>();
		for (int i = 0; i < n; i++) {
			stq.add(x);
		}
		String s = br.readLine();
		char order = s.charAt(0);
		int a = 0;
		if (order == 'i') {
			a = Integer.parseInt(s.substring(2));
		}
		while (order != 'e') {

			switch (order) {
			case 'i':
				stq.add(a);
				break;

			case 'r':
				if(stq.size() > 0) {
					stq.pop();					
				}
				break;

			case 's':
				Collections.sort(stq);
				break;

			case 't':
				if (stq.size() > 1) {
					int first = stq.remove(0);
					int last = stq.pop();
					stq.add(first);
					stq.add(0, last);
				}
				break;

			}

			s = br.readLine();
			order = s.charAt(0);
			if (order == 'i') {
				a = Integer.parseInt(s.substring(2));
			}
		}

		for (int q : stq) {
			sb.append(q).append(' ');
		}

		bw.write(sb.toString().trim());
		bw.flush();
	}

}