import java.io.*;

public class Main_Level_1_단어의개수세기 { // 제출일 2020-08-30 21:22
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 예시 1
		// input : "Goorm  Edu"
		// output : 2
		// 예시 2
		// input : " goo r m e du"
		// output : 5
		
		char[] arr = br.readLine().toCharArray();
		boolean isSpace = true;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(isSpace && arr[i] != ' ') {
				isSpace = false;
				cnt++;
			} else if(!isSpace && arr[i] == ' ') {
				isSpace = true;
			}
		}
		System.out.println(cnt);
	}
}