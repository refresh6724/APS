import java.util.Scanner;

class Solution_D3_6853_직사각형과점 // 제출일 2020-05-23 23:28 112,908 kb 623 ms
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int tmp = 0;
            if(x2 < x1) {
                tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if(y2 < y1) {
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            
            int a = 0;
            int b = 0;
            int c = 0;
            
            int n = sc.nextInt();            
            for(int i = 0; i<n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                
                if(x<x1 || y<y1 || x>x2 || y>y2) {
                	c++;
                } else if(x==x1 || y == y1 || x == x2 || y == y2) {
                    b++;
                } else {
                    a++;
                }
            }
            System.out.println(String.format("#%d %d %d %d", test_case, a, b, c));      
		}
	}
}
