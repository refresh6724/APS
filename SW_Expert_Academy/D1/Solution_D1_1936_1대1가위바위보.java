import java.util.Scanner;

public class Solution_D1_1936_1대1가위바위보 { // 제출일 2019-11-07 16:39 
	public static void main(String[] args) {
		// 가위 1 바위 2 보 3
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		switch(A) {
		case 1:
			if(B==2) System.out.println("B");
			else System.out.println("A");
			break;
		case 2:
			if(B==3) System.out.println("B");
			else System.out.println("A");
			break;
		case 3:
			if(B==1) System.out.println("B");
			else System.out.println("A");
			break;
		}
}}
