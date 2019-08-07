import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_D3_1225_암호생성기 { // 제출일 2019-08-07 18:07
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        for(int t=1; t<=10; t++) {
            br.readLine(); // 테스트케이스 줄 스킵
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                q.offer(Integer.parseInt(arr[i]));
            }
             
            // 기본형식 한 사이클에 5번  첫번째 수를 poll 후 i 빼고 offer
            // break 조건은 i를 뺐을때 0이하이면 0을 offer하고 출력
            int condition = 0;
            cycle:
            while(true) {
                for(int i=1; i<=5; i++){
                    condition = q.poll() -i;
                    if(condition <= 0) {
                        q.offer(0);
                        break cycle;
                    }
                    q.offer(condition);
                }
            }
             
            sb.append("#").append(t);
            for (int i = 0; i < 8; i++) {
                sb.append(" ").append(q.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
         
    }
}