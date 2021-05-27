import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_3052_나머지 { // 제출일 2020-09-23 23:04

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(br.readLine())%42);
		} 
		System.out.println(set.size());		
		
//		bw.write(sb.toString());
//		bw.flush();
	}

}