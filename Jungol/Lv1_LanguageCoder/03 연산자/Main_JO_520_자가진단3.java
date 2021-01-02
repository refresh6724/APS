import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_JO_520_자가진단3 { // 제출일 2021-01-02 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		System.out.println(a++);
		System.out.println(++a);
	}

}