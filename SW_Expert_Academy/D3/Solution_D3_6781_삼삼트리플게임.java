import java.util.Scanner;

class Solution_D3_6781_삼삼트리플게임
{ // 제출일 2020-05-24 23:59 20,796 kb 130 ms
    static char[] num, color;
    static boolean win;
    static int[] order;
    static boolean[] visited;
    
	public static void main(String args[]) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        testcase:
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 숏컷 : 색깔 조건 
            num = sc.next().toCharArray();
            color = sc.next().toCharArray();
            int red = 0;
            int green = 0;
            int blue = 0;

            for(int i=0; i<9; i++) {
            	if(color[i] == 'R') {
                    red++;
                } else if(color[i] == 'G') {
                    green++;
                } else {
                    blue++;
                } 
			}
            
            if(red%3 != 0 || green%3 != 0 || blue %3 != 0) {
                System.out.print(String.format("#%d Continue\n",test_case));
                continue testcase;
            }
            
            // 
            visited = new boolean[9];
            order = new int[9];
            win = false;
            for(int start = 0; start <9; start++) {
                visited[start] = true;
                order[0] = start;
                dfs(start, visited, 1);
                visited[start] = false;
            }            
            if(win) {
                System.out.print(String.format("#%d Win\n",test_case));
            } else {
                System.out.print(String.format("#%d Continue\n",test_case));
            }
		}
	}
    
    private static void dfs(int idx, boolean[] visited, int step) {
        if(win) return;
    	if(step == 9) {
        	// 7,8,9 번째 수가 Triple인지
            if(  color[order[6]]==color[order[7]] && color[order[7]]==color[order[8]] 
               && (    (num[order[6]] == num[order[7]] && num[order[7]] == num[order[8]])
                       || (num[order[6]]+1 == num[order[7]] && num[order[7]]+1 == num[order[8]])
                     )
              ) {
                win = true;
            } else {
                return;
            }            
        } else if( step == 6) {
        	// 4,5,6 번째 수가 Triple인지
            if(  color[order[3]]==color[order[4]] && color[order[4]]==color[order[5]] 
               && (    (num[order[3]] == num[order[4]] && num[order[4]] == num[order[5]])
                       || (num[order[3]]+1 == num[order[4]] && num[order[4]]+1 == num[order[5]])
                     )
              ) {
                // 계속 진행
            } else {
                return;
            }
        } else if( step == 3) {
            // 1,2,3번째 수가 Triple인지
        	if(  color[order[0]]==color[order[1]] && color[order[1]]==color[order[2]] 
               && (    (num[order[0]] == num[order[1]] && num[order[1]] == num[order[2]])
                       || (num[order[0]]+1 == num[order[1]] && num[order[1]]+1 == num[order[2]])
                     )
              ) {
                // 계속 진행
            } else {
                return;
            }
        }
        
        for(int next = 0; next <9; next++) {
            if(!visited[next]){                
                visited[next] = true;
                order[step] = next;
                dfs(next, visited, step+1);
                visited[next] = false;
            }
        }           
    }
}