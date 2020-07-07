import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_4371_항구에들어오는배 { // 제출일 2020-07-07 22:41 30,468 kb 335 ms

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

//		Reader s = new Reader();

		int TC = Integer.parseInt(br.readLine());
//		int TC = s.nextInt();
		testcase: for (int tc = 1; tc <= TC; tc++) {
			
			// 1일차 : 모든 배가 들어옴
			// 즐거운 날 : 한 척이라도 항구에 입항한 날
			// 각 배는 주기적으로 입항한다
			// N개 날짜(1부터 시작)가 주어질 때 최소 배의 숫자는

			sb.append('#').append(tc).append(' ');

			int N = Integer.parseInt(br.readLine()); // 5000 이하
			
			br.readLine(); // 1 생략
			
			int date = Integer.parseInt(br.readLine()) -1; 
			
			if(date == 2) {
				// 배는 한 척이다
				sb.append(2).append('\n');
				for (int i = 2; i < N; i++) {
					br.readLine();
				}
				continue testcase;
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(date);
			
			for (int i = 2; i < N; i++) {
				date = Integer.parseInt(br.readLine()) -1; 
				// 가장 큰 값이 1억이 되지 않는다
				// 입력되는 각 숫자에서 1을 빼야한다
				// 만약 방문주기가 2인 배가 있다면 가장 마지막 날짜가 되기 전까지 2의 배수가 모두 찍혀야 한다
				// 따라서 2와 3 이라면 1 2 3
				// 2와 4라면 2 4 인 데 이 경우에는 배수라서 한 척이 된다
				
				// date 가 주어지면 
				// 기존에 들어왔던 값들에 대해서 나눠 떨어지는 경우를 보고 
				// 나뉘면 배 숫자는 그대로고 모든 목록에 대해 나눠지지 않으면 목록에 date를 추가한다
				
				boolean find = false;
				
				for (int j = 0; j < list.size(); j++) {
					if(date%list.get(j)==0) {
						// 나뉘면 리스트 탐색을 중지하고 다음 date를 받는다
						// 나뉘지 않으면 list에 대해 계속 탐색한다
						find = true;
						break;
					} 
				}
				
				if(!find) { 
					// 전체 리스트에 대해 나뉘지 않는다면 리스트에 추가한다
					list.add(date);
				}
				
			}
			
			sb.append(list.size()).append('\n');

		}
		bw.write(sb.toString());
		bw.flush();
	}

	/**
	 * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	 */
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
	}

}