import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class Solution_D2_1928_Base64Decoder { // 제출일 2019-11-07 19:42 
	public static void main(String[] args) {
		// 3 byte = 24 bit
		// 6bit씩 4묶음
		// 입력되는 문자열은 이미 인코딩된 문자열
		// 디코딩하여 출력하자
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t =1; t <= T; t++) {
			byte[] input = sc.next().getBytes();
			Decoder decoder = Base64.getDecoder();
			byte[] planetext = decoder.decode(input);
			System.out.printf("#%d %s\n",t,new String(planetext));
		}
	}
}
