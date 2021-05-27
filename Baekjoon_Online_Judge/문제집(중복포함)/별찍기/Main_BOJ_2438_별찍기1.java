import java.util.Scanner;
public class Main_BOJ_2438_별찍기1 { // 제출일 2020-02-08 23:40
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n ; i++) {    
            for(int j=0; j<=i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());        
	}
}