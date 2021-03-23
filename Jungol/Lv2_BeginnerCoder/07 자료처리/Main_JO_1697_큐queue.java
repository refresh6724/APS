import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1697_큐queue { // 제출일 2021-03-23 23:53
	static class Node {
		int data;
		Node next;

		public Node() {
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return "this is " + this.data;
		}
	}

	static class MyQueue {
		private Node head;
		private Node tail;
		private int size;

		public MyQueue() {
			this.head = new Node();
			this.tail = this.head;
			this.size = 0;
		}

		public int size() {
			return this.size;
		}

		public void push(int data) {
			this.size++;
			Node next = new Node(data);
			this.tail.next = next;
			this.tail = next;
		}

		public int pop() throws Exception {
			if (!isEmpty()) {
				Node ret = this.head.next;
				this.head.next = ret.next;
				ret.next = null;
				this.size--;
				if(isEmpty()) {
					this.tail = this.head;
				}
				return ret.data;
			} else {
				throw new Exception("비어있는 큐입니다.");
			}
		}

		public boolean isEmpty() {
			if (this.size == 0) {
				return true;
			} else {
				return false;
			}
		}

		public int front() throws Exception {
			if (!isEmpty()) {
				return this.head.next.data;
			} else {
				throw new Exception("비어있는 큐입니다.");
			}

		}

		public int back() throws Exception {
			if (!isEmpty()) {
				return this.tail.data;
			} else {
				throw new Exception("비어있는 큐입니다.");
			}

		}

		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		MyQueue myQueue = new MyQueue();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String op = br.readLine();
			switch (op.charAt(0)) {
			case 'i':
				myQueue.push(Integer.parseInt(op.substring(2)));
				break;
			case 'o':
				try {
					sb.append(myQueue.pop()).append('\n');
				} catch (Exception e) {
					sb.append("empty\n");
				}
				break;
			case 'c':
				sb.append(myQueue.size()).append('\n');
				break;
			default:
				throw new Exception("잘못된 입력");
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}