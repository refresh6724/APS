import java.util.Scanner;

public class Solution_D1_2050_알파벳을숫자로변환 { // 제출일 2019-08-01 12:49

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str= sc.next();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ",arr[i]-64);
		}
	}

}
