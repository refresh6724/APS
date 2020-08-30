import java.io.*;

public class Main_Level_1_헷갈리는작대기 { // 제출일 2020-08-30 21:27
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 예시 1
		// input : "We wi1l we wi|I rock you!"
		// output : 1 
		//			1
		//			1
		//			1
				
		char[] arr = br.readLine().toCharArray();
		int[] cnt = new int[4];
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
			case '1':
				cnt[0]++;
				break;
			case 'I':
				cnt[1]++;
				break;
			case 'l':
				cnt[2]++;
				break;
			case '|':
				cnt[3]++;
				break;
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}