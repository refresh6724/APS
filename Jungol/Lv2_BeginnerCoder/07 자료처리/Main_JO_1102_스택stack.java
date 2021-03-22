import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1102_스택stack { // 제출일 2021-03-22 22:40

	static class MyStack {

		private static final int MAX = 100;
		private int size;
		private int[] stack;

		public MyStack() {
			stack = new int[MAX];
			size = -1;
		}

		public boolean isEmpty() {
			if (this.size == -1) {
				return true;
			}
			return false;
		}

		public boolean isFull() {
			if (this.size == MAX - 1) {
				return true;
			}
			return false;
		}

		public int size() {
			return this.size + 1;
		}

		public int top() throws Exception {
			if (isEmpty()) {
				throw new Exception("스택이 비어있습니다.");
			}
			return this.stack[this.size];
		}

		public void push(int data) throws Exception {
			if (isFull()) {
				throw new Exception("스택이 가득 찼습니다.");
			}
			this.size += 1;
			this.stack[this.size] = data;
		}

		public int pop() throws Exception {
			if (isEmpty()) {
				throw new Exception("스택이 비어있습니다.");
			}
			int ret = this.stack[this.size];
			this.size -= 1;
			return ret;
		}

	}

	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		MyStack myStack = new MyStack();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			switch (line.charAt(0)) {
			case 'i':
				myStack.push(Integer.parseInt(line.substring(2)));
				break;
			case 'c':
				sb.append(myStack.size()).append('\n');
				break;
			case 'o':
				try {
					sb.append(myStack.pop());
				} catch (Exception e) {
					sb.append("empty");
				} finally {
					sb.append('\n');
				}
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}