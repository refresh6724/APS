import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_115_형성평가5 { // 제출일 2021-01-01 23:39
	
	static class Human implements Comparable<Human> {
		String name;
		int height;
		int weight;

		public Human() {
			// TODO Auto-generated constructor stub
		}

		public Human(String name, int height, int weight) {
			super();
			this.name = name;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Human o) {
			if (this.height > o.height && this.weight > o.weight) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Human minsu = new Human("minsu", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());		
		Human kiyoung = new Human("kiyoung", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		System.out.println(minsu.compareTo(kiyoung));
	}

	
}