import java.io.*;

public class Main_Level_3_사은품교환하기 { // 제출일 2021-10-17 23:29
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < n; tc++) {
			String[] line = br.readLine().split(" ");
			// 최소 시즌 5 + 일반 7
			long season = Long.parseLong(line[0]);
			long normal = Long.parseLong(line[1]);
			
			long mok = season / 5;
			long nam = season % 5;
			
			if(normal >= mok * 7) {
				System.out.println(mok);
				continue;
			}
			long nmok = normal / 7;
			long nnam = normal % 7;			
			
			season -= nmok * 5;
			mok -= nmok;
			normal -= nmok * 7;
			
			while(mok >= 1 && nam + nnam < 12) {
				mok -= 1;
				nam += 5;
			}
			
			if(nam + nnam >= 12) {
				nam += nnam - 12;
				nmok += 1;
			}
			
			nam += mok * 5;
			nmok += (nam/12);
			
			System.out.println(nmok);
		}

	}
}